package cn.enaium.message.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: message
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void findAll() {
        System.out.println(messageRepository.findAll());
    }

}