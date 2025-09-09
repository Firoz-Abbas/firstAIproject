package com.spring.ai.firstproject.services.loginservices;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public interface LoginServices {
    Map<String, String> processLogin(String username, String password, Model model);
}
