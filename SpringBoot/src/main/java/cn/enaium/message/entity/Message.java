package cn.enaium.message.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Project: message
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
@Data
@Entity
public class Message {
    @Id
    private Integer id;
    private String author;
    private String message;
    private String time;
}
