package com.example.frealsb.Controllers;

import com.example.frealsb.Entities.Messsage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @MessageMapping("chat.register")
    @SendTo("topic/public")
    public Messsage register(@Payload Messsage messsage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", messsage.getSender());
        return messsage;
    }

    @MessageMapping("chat.send")
    @SendTo("topic/public")
    public Messsage sendMesssage(Messsage messsage, SimpMessageHeaderAccessor headerAccessor) {
        return messsage;
    }
}
