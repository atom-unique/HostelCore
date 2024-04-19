package org.kravchenko.view.impl;

import org.kravchenko.model.Service;
import org.kravchenko.view.ServiceView;

import java.util.List;
import java.util.Scanner;

public class ServiceViewImpl implements ServiceView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void allServices(List<Service> serviceList) {
        System.out.println("Available services:");
        serviceList.forEach(System.out::println);
    }

    @Override
    public Service addService() {
        Service service = new Service();
        System.out.println("Enter service name:");
        service.setName(scanner.nextLine());
        System.out.println("Enter service description:");
        service.setDescriotion(scanner.nextLine());
        System.out.println("Enter service price:");
        service.setPrice(scanner.nextInt());
        return service;
    }

    @Override
    public String findServiceByName() {
        System.out.println("Enter service name:");
        return scanner.nextLine();
    }

    @Override
    public int setPrice() {
        System.out.println("Enter service price:");
        return scanner.nextInt();
    }
}
