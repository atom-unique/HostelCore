package org.kravchenko.model;

import org.kravchenko.model.rating.Rating;

import java.util.List;
import java.util.UUID;

public class Room {

    private UUID id;
    private int number;
    private int price;
    private int capacity;
    private Rating rating;
    private boolean isOccupied;
    private boolean isInService;
    List<Guest> guestList;

    public Room() {
    }

    public Room(UUID id, int number, int price, int capacity, Rating rating) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isInService() {
        return isInService;
    }

    public void setInService(boolean inService) {
        isInService = inService;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", capacity=" + capacity +
                ", rating=" + rating +
                ", isOccupied=" + isOccupied +
                ", isInService=" + isInService +
                ", guestList=" + guestList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (number != room.number) return false;
        if (price != room.price) return false;
        if (capacity != room.capacity) return false;
        if (!id.equals(room.id)) return false;
        return rating == room.rating;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + number;
        result = 31 * result + price;
        result = 31 * result + capacity;
        result = 31 * result + rating.hashCode();
        return result;
    }
}
