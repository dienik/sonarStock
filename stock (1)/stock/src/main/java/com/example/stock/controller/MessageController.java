// package com.example.stock.controller;

// import java.security.Principal;

// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.CrossOrigin;

// @CrossOrigin(origins = "*")
// @Controller
// public class MessageController {
    
//     @MessageMapping("/message/")
//     @SendTo("/topic/response")
//     public void join(Principal principal) {
//         System.out.println(principal.getName().toString());
//     }
// }