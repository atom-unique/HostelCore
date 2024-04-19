package org.kravchenko.repository;

import org.kravchenko.model.Guest;

import java.util.List;

public interface GuestRepository {

    void addGuest(Guest guest);

    Guest findGuest(Guest guest);

    List<Guest> findAll();

    String removeGuest(Guest guest);
}
