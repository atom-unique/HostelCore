package org.kravchenko.model;

public class Service {

    private String name;
    private String descriotion;
    private int price;

    public Service() {
    }

    public Service(String name, String descriotion, int price) {
        this.name = name;
        this.descriotion = descriotion;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", descriotion='" + descriotion + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (price != service.price) return false;
        if (!name.equals(service.name)) return false;
        return descriotion.equals(service.descriotion);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + descriotion.hashCode();
        result = 31 * result + price;
        return result;
    }
}
