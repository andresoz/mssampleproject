package com.andresortiz.ms.roomreservationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationWebService {

    //private final RestTemplate restTemplate;

    private final RoomClient roomClient;
    private final ReservationClient reservationClient;
    private final GuestClient guestClient;

    public RoomReservationWebService(RoomClient roomClient, ReservationClient reservationClient, GuestClient guestClient) {
        this.roomClient = roomClient;
        this.reservationClient = reservationClient;
        this.guestClient = guestClient;
    }

    //    public RoomReservationWebService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false)String date){
//        var rooms = getAllRooms();
        var rooms = roomClient.getAllRooms();
        var roomReservations = new HashMap<Long, RoomReservation>();
        rooms.forEach(room -> {
            var roomReservation = new RoomReservation();
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomId(room.getId());
            roomReservations.put(room.getId(), roomReservation);
        });
        var localDate = LocalDate.parse(date);
        var reservations = reservationClient.getAllReservations(localDate);
        reservations.forEach(reservation -> {
            var roomReservation = roomReservations.get(reservation.getId());
            roomReservation.setDate(localDate);
            var guest = guestClient.getGuest(reservation.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return new ArrayList<>(roomReservations.values());
    }

//    private List<Room> getAllRooms(){
//        var roomResponse =
//                restTemplate.exchange("http://ROOMSERVICES/rooms/",
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<Room>>() {});
//        return roomResponse.getBody();
//    }
}
