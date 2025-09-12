package com.spring.ai.firstproject.services.loginservices;

import com.spring.ai.firstproject.model.employee.EmployeeModel;
import com.spring.ai.firstproject.repository.EmployeeRepository;
import com.spring.ai.firstproject.utility.ApplicationCookies;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServicesImpl implements LoginServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApplicationCookies applicationCookies;

    @Override
    public Map<String, String> processLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> result = new HashMap<>();

        EmployeeModel employee = employeeRepository.findAllByUsername(username);

        if (employee != null && employee.getPassword().equals(password)) {
            // Clear old cookies
            applicationCookies.removeAllCookies(request, response);

            // Add user cookie
            applicationCookies.addUserName(response, username);

            // Build success response
            result.put("status", "success");
            result.put("page", "home");
            result.put("username", employee.getUsername());
        } else {
            result.put("status", "error");
            result.put("page", "login");
            result.put("message", "Invalid username or password");
        }

        return result;
    }


//    @Override
//    public Map<String, String> processLogin(String username, String password, Model model, HttpServletRequest request, HttpServletResponse res) {
//        EmployeeModel employee = employeeRepository.findAllByUsername(username);
//
//        Map<String, String> response = new HashMap<>();
//        if (employee != null && employee.getPassword().equals(password)) {
//            applicationCookies.removeAllCookies(request, res);
//            applicationCookies.addUserName(res, username);
//
//            model.addAttribute("message", "Welcome " + employee.getUsername() + "!");
//            response.put("page", "home");
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            response.put("page", "login");
//        }
//
//        return response;
//    }

}
