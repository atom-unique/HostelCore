package org.kravchenko.service;

import org.kravchenko.model.Room;

import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    Room findRoom(Room room);

    List<Room> findAll();

    String removeRoom(Room room);
}
