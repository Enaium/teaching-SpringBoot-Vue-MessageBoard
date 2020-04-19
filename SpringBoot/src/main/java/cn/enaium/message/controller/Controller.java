package cn.enaium.message.controller;

import cn.enaium.message.entity.Message;
import cn.enaium.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Project: message
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
@RestController
public class Controller {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/getMessages")
    private List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/postMessage")
    private String postMessage(@RequestParam String author, @RequestParam String message) {
        if(author.replaceAll(" ","").equals("") || message.replaceAll(" ","").equals("")) {
            return "filed";
        }
        messageRepository.save(new Message((long) (messageRepository.findAll().size() + 1),author,message,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        return "success";
    }
}
