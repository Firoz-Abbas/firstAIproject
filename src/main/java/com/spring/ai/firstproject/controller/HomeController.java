package com.spring.ai.firstproject.controller;

import com.spring.ai.firstproject.services.loginservices.LoginServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private LoginServices loginServices;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // renders login.jsp
    }

    @GetMapping("/chatboat")
    public String showChatboatPage() {
        return "chatboat";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public Map<String, String> processLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
       return loginServices.processLogin(username, password, request, response);
    }
}
