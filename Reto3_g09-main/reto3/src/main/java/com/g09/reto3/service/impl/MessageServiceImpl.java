package com.g09.reto3.service.impl;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Message;
import com.g09.reto3.repository.MessageRepository;
import com.g09.reto3.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> findAllMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public Optional<Message> findOne(Long id){
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
    
    @Override
    public boolean delete(Long id){
        Optional<Message> message=findOne(id);
            if(!message.isEmpty()){
                messageRepository.delete(message.get());
                return true;        
            }
            return false;
        }
    /*public void delete(Long id){
        Optional<Message> message= findOne(id);
        if(message.isPresent()){
            messageRepository.delete(message.get());
        }
    }*/

    @Override
    public Message update(Message message){
        if(message.getIdMessage()!=null){
        Optional<Message> msn= messageRepository.findById(message.getIdMessage());

            if(!msn.isEmpty()){

                if(message.getMessageText()!=null){
                    msn.get().setMessageText(message.getMessageText());
                }
               
                messageRepository.save(msn.get());
                return msn.get();
                
            } else{
                return message;
            }
        }else{
            return message;
        }
     }
}
