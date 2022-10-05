package com.andresortiz.ms.guestservice;

import com.andresortiz.ms.guestservice.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
