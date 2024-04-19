package org.kravchenko;

import org.kravchenko.controller.GuestController;
import org.kravchenko.controller.RoomController;
import org.kravchenko.controller.ServiceController;
import org.kravchenko.model.Guest;
import org.kravchenko.model.Room;
import org.kravchenko.model.Service;
import org.kravchenko.model.rating.Rating;
import org.kravchenko.repository.GuestRepository;
import org.kravchenko.repository.RoomRepository;
import org.kravchenko.repository.ServiceRepository;
import org.kravchenko.repository.impl.GuestRepositoryImpl;
import org.kravchenko.repository.impl.RoomRepositoryImpl;
import org.kravchenko.repository.impl.ServiceRepositoryImpl;
import org.kravchenko.service.GuestService;
import org.kravchenko.service.RoomService;
import org.kravchenko.service.ServiceService;
import org.kravchenko.service.impl.GuestServiceImpl;
import org.kravchenko.service.impl.RoomServiceImpl;
import org.kravchenko.service.impl.ServiceServiceImpl;
import org.kravchenko.view.GuestView;
import org.kravchenko.view.RoomView;
import org.kravchenko.view.ServiceView;
import org.kravchenko.view.impl.GuestViewImpl;
import org.kravchenko.view.impl.RoomViewImpl;
import org.kravchenko.view.impl.ServiceViewImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Guest> guestList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            Guest guest = new Guest();
            guest.setCheckOutDate(LocalDate.now());
            guest.setId(UUID.randomUUID());
            guest.setName("Name" + i);
            guest.setSurname("Surname" + i);

            List<Service> serviceList = new ArrayList<>();

            for (int j = 6; j < 9; j++) {
                serviceList.add(new Service("name" + j, "description" + j, j * 100));
            }

            guest.setServiceList(serviceList);
            guestList.add(guest);
        }

        GuestRepository guestRepository = new GuestRepositoryImpl(guestList);
        GuestService guestService = new GuestServiceImpl(guestRepository);
        GuestView guestView = new GuestViewImpl();
        GuestController guestController = new GuestController(guestService, guestView);

        List<Room> roomList = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            Room room = new Room();
            room.setNumber(i);
            room.setId(UUID.randomUUID());
            room.setPrice(i * 10);
            room.setGuestList(guestList);
            if (i < 4) {
                room.setCapacity(i);
                room.setRating(Rating.FOUR);
            } else {
                room.setCapacity(2);
                room.setRating(Rating.FIVE);
            }
            roomList.add(room);
        }

        RoomRepository roomRepository = new RoomRepositoryImpl(roomList);
        RoomService roomService = new RoomServiceImpl(roomRepository);
        RoomView roomView = new RoomViewImpl();
        RoomController roomController = new RoomController(roomService, roomView);

        List<Service> serviceList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            serviceList.add(new Service("name" + i, "description" + i, i * 100));
        }

        ServiceRepository serviceRepository = new ServiceRepositoryImpl(serviceList);
        ServiceService serviceService = new ServiceServiceImpl(serviceRepository);
        ServiceView serviceView = new ServiceViewImpl();
        ServiceController serviceController = new ServiceController(serviceService, serviceView);

        boolean a = true;

        while (a == true) {
            System.out.println("Choose an action:");
            System.out.println("1 - Show all rooms.");
            System.out.println("2 - Show free rooms.");
            System.out.println("3 - Show all guests.");
            System.out.println("4 - Show free rooms count.");
            System.out.println("5 - Show guests count.");
            System.out.println("6 - Show rooms, free by date.");
            System.out.println("7 - Show total price for guest.");
            System.out.println("8 - Show three last guests for room.");
            System.out.println("9 - Show guest services list.");
            System.out.println("10 - Show all services.");
            System.out.println("11 - Show room details.");
            System.out.println("12 - Check in.");
            System.out.println("13 - Move out.");
            System.out.println("14 - Set room in service.");
            System.out.println("15 - Set room in use.");
            System.out.println("16 - Set room price.");
            System.out.println("17 - Set service price.");
            System.out.println("18 - Add room.");
            System.out.println("19 - Add service.");
            System.out.println("0 - EXIT.");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    roomController.showAll();
                    break;
                case 2:
                    roomController.showFree();
                    break;
                case 3:
                    guestController.allGuests();
                    break;
                case 4:
                    roomController.showFreeCount();
                    break;
                case 5:
                    guestController.guestsCount();
                    break;
                case 6:
                    roomController.freeByDateRooms();
                    break;
                case 7:
                    guestController.totalPrice();
                    break;
                case 8:

                    break;
                case 9:
                    guestController.showGuestServicesList();
                    break;
                case 10:
                    serviceController.showAll();
                    break;
                case 11:
                    roomController.showRoom();
                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:
                    roomController.setRoomInService();
                    break;
                case 15:
                    roomController.setRoomInUse();
                    break;
                case 16:
                    roomController.setRoomPrice();
                    break;
                case 17:
                    serviceController.setServicePrice();
                    break;
                case 18:
                    roomController.addRoom();
                    break;
                case 19:
                    serviceController.addService();
                    break;
                case 0:
                    a = false;
                    break;
                default:
                    System.out.println("Please, make correct choice!");
                    break;
            }
        }
    }
}