package com.spring.ai.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // renders login.jsp
    }

    @GetMapping("chatboat")
    public String showChatboatPage() {
        return "chatboat";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("message", "Welcome " + username + "!");
            return "home"; // redirect to home.jsp
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // reload login page with error
        }
    }
}
