package org.kravchenko.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Guest {

    private UUID id;
    private int roomNumber;
    private String name;
    private String surname;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<Service> serviceList = new ArrayList<>();

    public Guest() {
    }

    public Guest(UUID id, int roomNumber, String name, String surname, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.name = name;
        this.surname = surname;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", serviceList=" + serviceList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        if (roomNumber != guest.roomNumber) return false;
        if (!id.equals(guest.id)) return false;
        if (!name.equals(guest.name)) return false;
        if (!surname.equals(guest.surname)) return false;
        if (!Objects.equals(checkInDate, guest.checkInDate)) return false;
        if (!Objects.equals(checkOutDate, guest.checkOutDate)) return false;
        return Objects.equals(serviceList, guest.serviceList);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + roomNumber;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (checkInDate != null ? checkInDate.hashCode() : 0);
        result = 31 * result + (checkOutDate != null ? checkOutDate.hashCode() : 0);
        result = 31 * result + (serviceList != null ? serviceList.hashCode() : 0);
        return result;
    }
}
