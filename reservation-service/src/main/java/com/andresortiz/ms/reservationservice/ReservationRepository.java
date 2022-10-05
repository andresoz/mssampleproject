package com.andresortiz.ms.reservationservice;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
