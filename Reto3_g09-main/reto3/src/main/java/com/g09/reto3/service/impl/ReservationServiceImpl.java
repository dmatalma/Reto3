package com.g09.reto3.service.impl;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Reservation;
import com.g09.reto3.repository.ReservationRepository;
import com.g09.reto3.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findOne(Long id){
        return reservationRepository.findById(id);
    }

    public Optional<Reservation> getReservation(long id){
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        if(reservation.getIdReservation()==null){
            reservation.setStatus("created");
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> paux=reservationRepository.findById(reservation.getIdReservation());
            if(paux.isEmpty()){
                reservation.setStatus("created");
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    @Override
    public boolean delete(Long id){
        Optional<Reservation> reservation=findOne(id);
            if(!reservation.isEmpty()){
                reservationRepository.delete(reservation.get());
                return true;        
            }
            return false;
        }
    /*public void delete(Long id){
        Optional<Reservation> reservation= findOne(id);
        if(reservation.isPresent()){
            reservationRepository.delete(reservation.get());
        }
    }*/

    @Override
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
        Optional<Reservation> rsv= reservationRepository.findById(reservation.getIdReservation());

            if(!rsv.isEmpty()){

                if(reservation.getStartDate()!=null){
                    rsv.get().setStartDate(reservation.getStartDate());
                }

                if(reservation.getDevolutionDate()!=null){
                    rsv.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if(reservation.getStatus()!=null){
                    rsv.get().setStatus(reservation.getStatus());
                }

                if(reservation.getScore()!=null){
                    rsv.get().setScore(reservation.getScore());
                }

                reservationRepository.save(rsv.get());
                return rsv.get();
                
            } else{
                return reservation;
            }
        }else{
            return reservation;
        }
     }
}
