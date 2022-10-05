package com.andresortiz.ms.guestservice.repositories;

import com.andresortiz.ms.guestservice.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
