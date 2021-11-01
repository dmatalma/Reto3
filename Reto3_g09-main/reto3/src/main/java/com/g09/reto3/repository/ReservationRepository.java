package com.g09.reto3.repository;
import java.util.Optional;

import com.g09.reto3.entity.Reservation;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    
    Optional<Reservation> findById(Long id);
}
