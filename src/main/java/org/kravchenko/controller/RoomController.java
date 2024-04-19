package org.kravchenko.controller;

import org.kravchenko.model.Room;
import org.kravchenko.service.RoomService;
import org.kravchenko.view.RoomView;

public class RoomController {

    private RoomService roomService;
    private RoomView roomView;

    public RoomController(RoomService roomService, RoomView roomView) {
        this.roomService = roomService;
        this.roomView = roomView;
    }

    public void showAll() {
        roomView.allRooms(roomService.findAll());
    }

    public void showFree() {
        roomView.freeRooms(roomService.findAll());
    }

    public void showFreeCount() {
        roomView.freeRoomsCount(roomService.findAll());
    }

    public void addRoom() {
        roomService.addRoom(roomView.addRoom());
    }

    public void setRoomInService() {
        roomView.allRooms(roomService.findAll());
        Room room = findRoomByNumber();
        room.setInService(true);
    }

    public void setRoomInUse() {
        roomView.allRooms(roomService.findAll());
        Room room = findRoomByNumber();
        room.setInService(false);
    }

    public void setRoomPrice() {
        roomView.allRooms(roomService.findAll());
        Room room = findRoomByNumber();
        room.setPrice(roomView.setPrice());
    }

    public void showRoom() {
        roomView.allRooms(roomService.findAll());
        roomView.showRoom(findRoomByNumber());
    }

    public void freeByDateRooms(){
        roomView.freeByDateRooms(roomService.findAll());
    }

    private Room findRoomByNumber() {
        int number = roomView.findRoomByNumber();
        return roomService.findRoom(
                roomService.findAll()
                        .stream()
                        .filter(r -> r.getNumber() == number)
                        .findAny()
                        .orElseThrow()
        );
    }
}
