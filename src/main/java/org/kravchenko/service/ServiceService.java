package org.kravchenko.service;

import org.kravchenko.model.Service;

import java.util.List;

public interface ServiceService {

    void addService(Service service);

    Service findService(Service service);

    List<Service> findAll();

    String removeService(Service service);
}
