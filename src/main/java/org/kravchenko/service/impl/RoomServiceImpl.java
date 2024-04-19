package org.kravchenko.service.impl;

import org.kravchenko.model.Room;
import org.kravchenko.repository.RoomRepository;
import org.kravchenko.repository.impl.RoomRepositoryImpl;
import org.kravchenko.service.RoomService;

import java.util.List;
import java.util.UUID;

public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoom(Room room) {
        room.setId(UUID.randomUUID());
        roomRepository.addRoom(room);
    }

    @Override
    public Room findRoom(Room room) {
        return roomRepository.findRoom(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public String removeRoom(Room room) {
        return roomRepository.removeRoom(room);
    }
}
