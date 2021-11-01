package com.g09.reto3.repository;

import com.g09.reto3.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
    
}
