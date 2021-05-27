package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Employee;
import com.example.simpleapp.domain.User;
import com.example.simpleapp.service.EmployeeService;
import com.example.simpleapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    //To get login page
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLoginPage() {
        //return html page name
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not Found");
        }

        if (userByUsername.getPassword().equals(password)){

            return "redirect:/home";
        }

        model.addAttribute("invalidCredentials", true);
        return "redirect:/login";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("listEmployees", employees);
        return "/home";
    }

    @RequestMapping("/new")
    public String newEmployeePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute(employee);
        return "redirect:/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/home";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Employee employee = employeeService.findEmployeeById(id);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping("delete/{id}")
    public String deleteEmployeePage(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/home";
    }

}
