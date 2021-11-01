package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.Reportes.ContadorClientes;
import co.usa.ciclo3.reto3.Reportes.StatusReservas;
import co.usa.ciclo3.reto3.model.Reservation;
import co.usa.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            p.setStatus("created");
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(p.getIdReservation());
            if(paux.isEmpty()){
                p.setStatus("created");
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteReservation(int reservationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public StatusReservas getReporteStatusReservaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Reservation> getReporteTiempoReservaciones(String dateOne, String dateTwo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ContadorClientes> getTopClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
