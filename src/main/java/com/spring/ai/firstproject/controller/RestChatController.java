package com.spring.ai.firstproject.controller;


import com.spring.ai.firstproject.model.tuitor.Tut;
import com.spring.ai.firstproject.services.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class RestChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat/{message}")
    public ResponseEntity<Tut> getChat(@PathVariable String message) {
        Tut content=chatService.getChat(message);
//        String content= "hi i am open AI version 5.";
        return ResponseEntity.ok(content);
    }
}
