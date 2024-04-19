package org.kravchenko.view;

import org.kravchenko.model.Service;

import java.util.List;

public interface ServiceView {

    void allServices(List<Service> serviceList);

    Service addService();

    String findServiceByName();

    int setPrice();
}
