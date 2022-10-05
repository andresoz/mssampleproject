package com.andresortiz.ms.guestservice.web;

import com.andresortiz.ms.guestservice.entities.Reservation;
import com.andresortiz.ms.guestservice.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {

    private final ReservationRepository repository;

    public ReservationWebServices(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    Iterable<Reservation> getAllReservations(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Reservation getReservation(@PathVariable("id") long id){
        return repository.findById(id).get();
    }
}
