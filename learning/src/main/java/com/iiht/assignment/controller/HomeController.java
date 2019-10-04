package com.iiht.assignment.controller;

import java.util.List;

import com.iiht.assignment.entity.User;
import com.iiht.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/users")
    public String users(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("activeLink", "admin");
        return "admin/users";
    }

    @GetMapping(value = "/admin/admin")
    public String adminPage(Model model) {
        model.addAttribute("activeLink", "admin");
        return "admin/admin";

    }
}
