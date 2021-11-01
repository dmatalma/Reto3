package com.g09.reto3.service;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Skates;

public interface SkatesService {

    Optional<Skates> findOne(Long id);

    List<Skates> findAllSkates();

    Skates save(Skates skate);

    boolean delete(Long id);

    Skates update(Skates skate);
    
}
