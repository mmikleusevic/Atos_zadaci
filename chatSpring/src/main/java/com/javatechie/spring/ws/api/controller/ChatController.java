/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.spring.ws.api.controller;

import com.javatechie.spring.ws.api.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Marin
 */
@Controller
public class ChatController {
    
    @MessageMapping("/chat.register")
    @SendTo("/topic/public") 
    public Message register(@Payload Message message,SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
    @MessageMapping("/chat.send")
    @SendTo("/topic/public") 
    public Message sendMessage(@Payload Message message ){
        return message;
    }
}
