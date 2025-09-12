package com.spring.ai.firstproject.services;

import com.spring.ai.firstproject.model.tuitor.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {


    private ChatClient chatClient;
    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public Tut getChat(String m) {

        Prompt prompt = new Prompt(m);
        Tut totorial = chatClient
                .prompt(prompt)
                .call()
                .entity(Tut.class);
        return totorial;


        /*var content = chatClient
                .prompt(prompt)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
        return content;
*/
        /*Prompt prompt = new Prompt(m);
        var metadata = chatClient
                .prompt(prompt)
                .call()
                .chatResponse()
                .getMetadata();
        System.out.println("metadata: " + metadata);
        return "";*/

        /*String content = chatClient
                .prompt()
                .user(m)
                .system("As as expert in cricket")
                .call()
                .content();
        return content;*/
    }


    /*private final ChatClient openChatClient;
    public ChatServiceImpl(@Qualifier("openAiChatClient") ChatClient openAiChatClient) {
        this.openChatClient = openAiChatClient;

        @Override
    public String getChat(String m) {
        return openChatClient.prompt(m).call().content();
    }
    }*/
}
