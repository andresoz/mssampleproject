package com.andresortiz.ms.guestservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "ROOM_NUMBER")
    String roomNumber;

    @Column(name = "BED_INFO")
    String bedInfo;
}
