package com.g09.reto3.service.impl;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Clients;
import com.g09.reto3.repository.ClientsRepository;
import com.g09.reto3.service.ClientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public List<Clients> findAllClients() {
                return (List<Clients>) clientsRepository.findAll();
    }

    @Override
    public Optional<Clients> findOne(Long id){
        return clientsRepository.findById(id);
    }

    @Override
    @Transactional
    public Clients save(Clients client) {
        
        return clientsRepository.save(client);
    }

    @Override
    public boolean delete(Long id){
        Optional<Clients> client=findOne(id);
            if(!client.isEmpty()){
                clientsRepository.delete(client.get());
                return true;        
            }
            return false;
        }
    /*public void delete(Long id){
        Optional<Clients> client= findOne(id);
        if(client.isPresent()){
            clientsRepository.delete(client.get());
        }
    }*/

    @Override
    public Clients update(Clients client){
        if(client.getIdClient()!=null){
        Optional<Clients> cln= clientsRepository.findById(client.getIdClient());

            if(!cln.isEmpty()){

                if(client.getAge()!=0 && client.getAge()>0){
                    cln.get().setAge(client.getAge());
                }

                if(client.getEmail()!=null){
                    cln.get().setEmail(client.getEmail());
                }

                if(client.getName()!=null){
                    cln.get().setName(client.getName());
                }

                if(client.getPassword()!=null){
                    cln.get().setPassword(client.getPassword());
                }
               
                clientsRepository.save(cln.get());
                return cln.get();
                
            } else{
                return client;
            }
        }else{
            return client;
        }
     }


    
}
