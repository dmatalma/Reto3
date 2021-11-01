package com.g09.reto3.service;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Clients;

public interface ClientsService {

    Optional<Clients> findOne(Long id);

    List<Clients> findAllClients();

    Clients save(Clients client);

    boolean delete(Long id);

    Clients update(Clients client);
    
}
