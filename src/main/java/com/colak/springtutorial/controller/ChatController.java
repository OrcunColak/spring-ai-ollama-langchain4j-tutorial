package com.colak.springtutorial.controller;

import com.colak.springtutorial.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    // http://localhost:8080/chat
    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        return chatService.chat(prompt);
    }

    @GetMapping(value = "/stream-chat", produces = "text/event-stream")
    public Flux<String> streamChat(@RequestParam String prompt) {
        return chatService.streamChat(prompt);
    }

    @GetMapping(value = "/stream-assistant", produces = "text/event-stream")
    public Flux<String> streamAssistant(@RequestParam String prompt) {
        return chatService.streamAssistant(prompt);
    }

}
