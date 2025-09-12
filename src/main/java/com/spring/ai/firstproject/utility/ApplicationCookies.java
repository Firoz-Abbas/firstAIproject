package com.spring.ai.firstproject.utility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCookies {

    private final int maxAge = 12 * 60 * 60;

    public void addUserName(HttpServletResponse response, String userName) {
//        Cookie cookie = new Cookie("username", Utility.encode(userName));
        Cookie cookie = new Cookie("username", userName);
        cookie.setMaxAge(maxAge); // expires in 1 day
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public void removeAllCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
    }
}
