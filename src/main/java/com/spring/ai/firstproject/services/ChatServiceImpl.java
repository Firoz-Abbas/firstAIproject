package com.spring.ai.firstproject.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient openChatClient;
    public ChatServiceImpl(@Qualifier("openAiChatClient") ChatClient openAiChatClient) {
        this.openChatClient = openAiChatClient;
    }


    /*private ChatClient chatClient;
    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }*/

    @Override
    public String getChat(String m) {
        return openChatClient.prompt(m).call().content();
    }
}
