package com.andresortiz.ms.reservationservice;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ROOM_ID")
    private long roomId;

    @Column(name = "GUEST_ID")
    private long guestID;

    @Column(name = "RES_DATE")
    private LocalDate resDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public LocalDate getResDate() {
        return resDate;
    }

    public void setResDate(LocalDate resDate) {
        this.resDate = resDate;
    }
}
