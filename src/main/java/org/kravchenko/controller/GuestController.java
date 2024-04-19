package org.kravchenko.controller;

import org.kravchenko.model.Guest;
import org.kravchenko.model.Room;
import org.kravchenko.service.GuestService;
import org.kravchenko.service.RoomService;
import org.kravchenko.service.impl.RoomServiceImpl;
import org.kravchenko.view.GuestView;

public class GuestController {

    private GuestService guestService;
    private GuestView guestView;

    public GuestController(GuestService guestService, GuestView guestView) {
        this.guestService = guestService;
        this.guestView = guestView;
    }

    public void addGuest() {
        guestService.addGuest(guestView.addGuest());
    }

    public void allGuests() {
        guestView.allGuests(guestService.findAll());
    }

    public void guestsCount() {
        guestView.guestsCount(guestService.findAll());
    }

    public void showGuestServicesList() {
        allGuests();
        guestView.guestServicesList(findGuestBySurname());
    }

    public void totalPrice() {
        allGuests();

        int roomNumber = findGuestBySurname().getRoomNumber();

//        Room room = roomService.findRoom(
//                roomService.findAll()
//                        .stream()
//                        .filter(r -> r.getNumber() == number)
//                        .findAny()
//                        .orElseThrow()
//        );

        guestView.totalPrice(findGuestBySurname());
    }

    private Guest findGuestBySurname() {
        String surname = guestView.findGuestBySurname();
        return guestService.findGuest(
                guestService.findAll()
                        .stream()
                        .filter(g -> g.getSurname().equals(surname))
                        .findAny()
                        .orElseThrow()
        );
    }
}
