package com.andresortiz.ms.roomservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebService {

    private final RoomRepository repository;

    public RoomWebService(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Room> getAllRooms(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Room getRoom(@PathVariable("id") long id){
        return repository.findById(id).get();
    }

}