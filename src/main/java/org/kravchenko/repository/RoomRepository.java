package org.kravchenko.repository;

import org.kravchenko.model.Room;

import java.util.List;

public interface RoomRepository {

    void addRoom(Room room);

    Room findRoom(Room room);

    List<Room> findAll();

    String removeRoom(Room room);
}
