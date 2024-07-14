package com.staffs.myacademy.contollers;

import com.staffs.myacademy.models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/message")
    public Message send(){
        return new Message("Hello world");
    }

    @PostMapping("/message")
    public Message echo(@RequestBody Message message){
        return message;
    }
}
