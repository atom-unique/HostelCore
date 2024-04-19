package org.kravchenko.repository.impl;

import org.kravchenko.model.Room;
import org.kravchenko.repository.RoomRepository;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    List<Room> roomList;

    public RoomRepositoryImpl(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public void addRoom(Room room) {
        roomList.add(room);
    }

    @Override
    public Room findRoom(Room room) {
        if (roomList.contains(room)) {
            return roomList.get(roomList.indexOf(room));
        }
        return null;
    }

    @Override
    public List<Room> findAll() {
        return roomList;
    }

    @Override
    public String removeRoom(Room room) {
        if (roomList.remove(room)) {
            return "Done";
        }
        return "Did not found room";
    }
}
