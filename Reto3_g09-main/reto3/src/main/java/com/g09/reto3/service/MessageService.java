package com.g09.reto3.service;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Message;

public interface MessageService {

    Optional<Message> findOne(Long id);

    List<Message> findAllMessages();

    Message save(Message message);

   boolean delete(Long id);

    Message update(Message message);
    
}
