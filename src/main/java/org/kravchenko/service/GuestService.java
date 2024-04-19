package org.kravchenko.service;

import org.kravchenko.model.Guest;

import java.util.List;

public interface GuestService {

    void addGuest(Guest guest);

    Guest findGuest(Guest guest);

    List<Guest> findAll();

    String removeGuest(Guest guest);
}
