package org.kravchenko.repository.impl;

import org.kravchenko.model.Service;
import org.kravchenko.repository.ServiceRepository;

import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {

    private List<Service> serviceList;

    public ServiceRepositoryImpl(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public void addService(Service service) {
        this.serviceList.add(service);
    }

    @Override
    public Service findService(Service service) {
        if (serviceList.contains(service)) {
            return serviceList.get(serviceList.indexOf(service));
        }
        return null;
    }

    @Override
    public List<Service> findAll() {
        return serviceList;
    }

    @Override
    public String removeService(Service service) {
        if (serviceList.remove(service)) {
            return "Done";
        }
        return "Did not found service";
    }
}
