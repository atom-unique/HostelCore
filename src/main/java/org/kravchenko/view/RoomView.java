package org.kravchenko.view;

import org.kravchenko.model.Room;

import java.util.List;

public interface RoomView {

    void allRooms(List<Room> roomList);

    void freeRooms(List<Room> roomList);

    void freeByDateRooms(List<Room> roomList);

    Room addRoom();

    void freeRoomsCount(List<Room> roomList);

    int findRoomByNumber();

    int setPrice();

    void showRoom(Room room);
}
