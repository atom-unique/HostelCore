package org.kravchenko.view;

import org.kravchenko.model.Guest;

import java.util.List;

public interface GuestView {

    void allGuests(List<Guest> guestList);

    Guest addGuest();

    void guestsCount(List<Guest> guestList);

    String findGuestBySurname();

    void guestServicesList(Guest guest);

    void totalPrice(Guest guest);
}
