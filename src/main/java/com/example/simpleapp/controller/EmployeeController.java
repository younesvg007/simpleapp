package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Employee;
import com.example.simpleapp.domain.Function;
import com.example.simpleapp.domain.User;
import com.example.simpleapp.service.EmployeeService;
import com.example.simpleapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

        String userRole =  "";
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername != null && userByUsername.getPassword().equals(password)) {

            for (Function f : userByUsername.getFunctions()) {
                if (Long.valueOf(f.getId()).equals(userByUsername.getId())) {
                    userRole = f.getName();
                }
            }

            session.setAttribute("userfunction", userRole);
            Cookie cookie = new Cookie(userByUsername.getUsername(), userByUsername.getPassword());
            response.addCookie(cookie);

            return "account/welcome";
        } else {
            modelMap.put("error", "Invalid Account");
            return "account/index";
        }
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String viewWelcomePage(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("listEmployees", employees);
        return "welcome";
    }

    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showFormForAddEmployee(HttpSession session, Model model) {
        Employee employee = new Employee();
        //if (session.getAttribute("userfunction").toString())
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @RequestMapping(value = "updateForm", method = RequestMethod.GET)
    public String showFormForUpdateEmployee(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @RequestMapping(value = "saveCustomer", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/account/welcome";
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestParam("id") Long id)  {
        employeeService.deleteEmployee(id);
        return "redirect:/account/welcome";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            c.setMaxAge(0);
            response.addCookie(c);
        }
        session.removeAttribute("userfunction");
        return "redirect:../account";
    }

}
