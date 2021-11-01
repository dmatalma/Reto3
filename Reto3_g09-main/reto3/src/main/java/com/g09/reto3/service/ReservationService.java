package com.g09.reto3.service;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Reservation;

public interface ReservationService {

    Optional<Reservation> findOne(Long id);

    List<Reservation> findAllReservations();

    Reservation save(Reservation reservation);
    
   boolean delete(Long id);

    Reservation update(Reservation reservation);
    
}
