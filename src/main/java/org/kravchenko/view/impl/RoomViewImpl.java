package org.kravchenko.view.impl;

import org.kravchenko.model.Guest;
import org.kravchenko.model.Room;
import org.kravchenko.model.rating.Rating;
import org.kravchenko.view.RoomView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RoomViewImpl implements RoomView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void allRooms(List<Room> roomList) {
        System.out.println("All rooms:");
        roomList.forEach(System.out::println);
    }

    @Override
    public void freeRooms(List<Room> roomList) {
        System.out.println("Free rooms:");
        roomList.stream()
                .filter(room -> room.isOccupied() == false)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Override
    public void freeByDateRooms(List<Room> roomList) {
        System.out.println("Enter date (yyyy-MM-dd):");
        String dateLine = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateLine, formatter);
        for (Room room : roomList) {
            int count = 0;
            List<Guest> guestList = room.getGuestList();
            for (Guest guest : guestList) {
                if (date.isAfter(guest.getCheckOutDate())) {
                    count++;
                }
            }
            if (guestList.size() == count) {
                System.out.println(room);
            }
        }
    }

    @Override
    public Room addRoom() {
        Room room = new Room();
        System.out.println("Enter room number:");
        room.setNumber(scanner.nextInt());
        System.out.println("Enter price:");
        room.setPrice(scanner.nextInt());
        System.out.println("Enter capacity:");
        room.setCapacity(scanner.nextInt());
        System.out.println("Enter rating (1 to 5):");
        int rating = scanner.nextInt();
        switch (rating) {
            case 1:
                room.setRating(Rating.ONE);
                break;
            case 2:
                room.setRating(Rating.TWO);
                break;
            case 3:
                room.setRating(Rating.THREE);
                break;
            case 4:
                room.setRating(Rating.FOUR);
                break;
            case 5:
                room.setRating(Rating.FIVE);
                break;
            default:
                System.out.println("Make correct choose");
                break;
        }
        room.setGuestList(new ArrayList<>());
        return room;
    }

    @Override
    public void freeRoomsCount(List<Room> roomList) {
        System.out.println("Available free rooms:");
        System.out.println(roomList.stream().filter(room -> room.isOccupied() == false).count());
    }

    @Override
    public int findRoomByNumber() {
        System.out.println("Enter room number:");
        return scanner.nextInt();
    }

    @Override
    public int setPrice() {
        System.out.println("Enter number price:");
        return scanner.nextInt();
    }

    @Override
    public void showRoom(Room room) {
        System.out.println(room);
    }
}
