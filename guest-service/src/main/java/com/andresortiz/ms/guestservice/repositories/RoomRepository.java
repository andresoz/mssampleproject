package com.andresortiz.ms.guestservice.repositories;

import com.andresortiz.ms.guestservice.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
