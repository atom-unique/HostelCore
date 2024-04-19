package org.kravchenko.service.impl;

import org.kravchenko.model.Guest;
import org.kravchenko.repository.GuestRepository;
import org.kravchenko.repository.impl.GuestRepositoryImpl;
import org.kravchenko.service.GuestService;

import java.util.List;
import java.util.UUID;

public class GuestServiceImpl implements GuestService {

    private GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void addGuest(Guest guest) {
        guest.setId(UUID.randomUUID());
        guestRepository.addGuest(guest);
    }

    @Override
    public Guest findGuest(Guest guest) {
        return guestRepository.findGuest(guest);
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public String removeGuest(Guest guest) {
        return guestRepository.removeGuest(guest);
    }
}
