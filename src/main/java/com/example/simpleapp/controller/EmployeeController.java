package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Function;
import com.example.simpleapp.domain.User;
import com.example.simpleapp.service.EmployeeService;
import com.example.simpleapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "account")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "account/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            HttpServletResponse response,
            ModelMap modelMap) {

        String role = "";
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername != null && userByUsername.getPassword().equals(password)) {

            for (Function f : userByUsername.getFunctions()) {
                if (Long.valueOf(f.getId()).equals(userByUsername.getId())) {
                    role = f.getName();
                }
            }

            session.setAttribute("username", role);
            //response.addCookie(new Cookie(userByUsername.getUsername(), );
            return "account/welcome";
        } else {
            modelMap.put("error", "Invalid Account");
            return "account/index";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:../account";
    }

}
