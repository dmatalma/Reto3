package com.g09.reto3.controller;

import java.util.List;

import com.g09.reto3.entity.Reservation;
import com.g09.reto3.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

@CrossOrigin(origins="*")
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    
    ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> findAllReservations(){
        return reservationService.findAllReservations();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Reservation create(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Long id){
        return reservationService.delete(id);
    }
    /*@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        reservationService.delete(id);
        return ResponseEntity.ok().build();
    }*/
    
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

}
