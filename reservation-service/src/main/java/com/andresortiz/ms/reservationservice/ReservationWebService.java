package com.andresortiz.ms.reservationservice;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reservations")
public class ReservationWebService {

    private final ReservationRepository repository;

    public ReservationWebService(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Reservation> getAllReservations(@RequestParam(name = "date", required = false) LocalDate date){
        if(null != date){
            return repository.findAllByDate(date);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Reservation getReservation(@PathVariable("id") long id){
        return repository.findById(id).get();
    }

}