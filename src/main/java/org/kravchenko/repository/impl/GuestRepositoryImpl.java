package org.kravchenko.repository.impl;

import org.kravchenko.model.Guest;
import org.kravchenko.repository.GuestRepository;

import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {

    List<Guest> guestList;

    public GuestRepositoryImpl(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    @Override
    public Guest findGuest(Guest guest) {
        if (guestList.contains(guest)) {
            return guestList.get(guestList.indexOf(guest));
        }
        return null;
    }

    @Override
    public List<Guest> findAll() {
        return guestList;
    }

    @Override
    public String removeGuest(Guest guest) {
        if (guestList.remove(guest)) {
            return "Done";
        }
        return "Did not found guest";
    }
}
