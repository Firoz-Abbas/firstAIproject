package com.spring.ai.firstproject.services.loginservices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public interface LoginServices {
    Map<String, String> processLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
