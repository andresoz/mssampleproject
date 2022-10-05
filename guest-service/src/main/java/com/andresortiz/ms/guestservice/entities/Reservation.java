package com.andresortiz.ms.guestservice.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long id;

    @Column(name = "ROOM_ID")
    private long roomId;

    @Column(name = "GUEST_ID")
    private long guestID;

    @Column(name = "RES_DATE")
    private LocalDate resDate;
}
