package org.kravchenko.controller;

import org.kravchenko.model.Service;
import org.kravchenko.service.ServiceService;
import org.kravchenko.view.ServiceView;

public class ServiceController {

    private ServiceService serviceService;
    private ServiceView serviceView;

    public ServiceController(ServiceService serviceService, ServiceView serviceView) {
        this.serviceService = serviceService;
        this.serviceView = serviceView;
    }

    public void showAll() {
        serviceView.allServices(serviceService.findAll());
    }

    public void addService() {
        serviceService.addService(serviceView.addService());
    }

    public void setServicePrice() {
        serviceView.allServices(serviceService.findAll());
        Service service = findServiceByName();
        service.setPrice(serviceView.setPrice());
    }

    private Service findServiceByName() {
        String name = serviceView.findServiceByName();
        return serviceService.findService(
                serviceService.findAll()
                        .stream()
                        .filter(s -> s.getName().equals(name))
                        .findAny()
                        .orElseThrow()
        );
    }
}
