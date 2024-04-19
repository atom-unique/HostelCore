package org.kravchenko.service.impl;

import org.kravchenko.model.Service;
import org.kravchenko.repository.ServiceRepository;
import org.kravchenko.repository.impl.ServiceRepositoryImpl;
import org.kravchenko.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void addService(Service service) {
        serviceRepository.addService(service);
    }

    @Override
    public Service findService(Service service) {
        return serviceRepository.findService(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public String removeService(Service service) {
        return serviceRepository.removeService(service);
    }
}
