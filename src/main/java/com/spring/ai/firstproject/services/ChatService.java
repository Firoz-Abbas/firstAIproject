package com.spring.ai.firstproject.services;

import com.spring.ai.firstproject.model.tuitor.Tut;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    Tut getChat(String map);
}
