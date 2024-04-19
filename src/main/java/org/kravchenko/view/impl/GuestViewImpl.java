package org.kravchenko.view.impl;

import org.kravchenko.model.Guest;
import org.kravchenko.model.Service;
import org.kravchenko.view.GuestView;
import org.kravchenko.view.RoomView;

import java.util.List;
import java.util.Scanner;

public class GuestViewImpl implements GuestView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void allGuests(List<Guest> guestList) {
        System.out.println("All guests:");
        guestList.forEach(System.out::println);
    }

    @Override
    public Guest addGuest() {
        Guest guest = new Guest();
        System.out.println("Enter guest name:");
        guest.setName(scanner.nextLine());
        System.out.println("Enter guest surname:");
        guest.setName(scanner.nextLine());
        return guest;
    }

    @Override
    public void guestsCount(List<Guest> guestList) {
        System.out.println("Count of guests:");
        System.out.println(guestList.stream().count());
    }

    @Override
    public String findGuestBySurname() {
        System.out.println("Enter guest surname:");
        return scanner.nextLine();
    }

    @Override
    public void guestServicesList(Guest guest) {
        System.out.println("Guest services list:");
        guest.getServiceList().forEach(System.out::println);
    }

    @Override
    public void totalPrice(Guest guest) {
        int total = 0;
        for (Service service : guest.getServiceList()) {
            total += service.getPrice();
        }
        System.out.println("Total price for guest: \n" + total);
    }
}
