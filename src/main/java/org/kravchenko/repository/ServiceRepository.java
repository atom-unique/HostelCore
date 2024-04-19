package org.kravchenko.repository;

import org.kravchenko.model.Service;

import java.util.List;

public interface ServiceRepository {

    void addService(Service service);

    Service findService(Service service);

    List<Service> findAll();

    String removeService(Service service);
}
