package cn.enaium.message.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Project: message
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    private Long id;
    private String author;
    private String message;
    private String time;
}
