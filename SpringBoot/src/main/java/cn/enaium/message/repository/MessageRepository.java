package cn.enaium.message.repository;

import cn.enaium.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: message
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
