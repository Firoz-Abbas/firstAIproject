package com.spring.ai.firstproject.services.loginservices;

import com.spring.ai.firstproject.model.employee.EmployeeModel;
import com.spring.ai.firstproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServicesImpl implements LoginServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Map<String, String> processLogin(String username, String password, Model model) {
        EmployeeModel employee = employeeRepository.findAllByUsername(username);

        Map<String, String> response = new HashMap<>();
        if (employee != null && employee.getPassword().equals(password)) {
            model.addAttribute("message", "Welcome " + employee.getUsername() + "!");
            response.put("page", "home");
        } else {
            model.addAttribute("error", "Invalid username or password");
            response.put("page", "login");
        }
        return response;
    }

}
