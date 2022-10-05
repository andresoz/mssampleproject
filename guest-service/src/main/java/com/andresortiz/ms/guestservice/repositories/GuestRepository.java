package com.andresortiz.ms.guestservice.repositories;

import com.andresortiz.ms.guestservice.entities.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
