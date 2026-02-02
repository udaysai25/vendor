package com.example.vendormanagement.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.vendormanagement.repository.ServiceCategoryRepository;

import jakarta.annotation.PostConstruct;

@Component
public class ServiceCategoryLoader {

    private final ServiceCategoryRepository repository;

    public ServiceCategoryLoader(ServiceCategoryRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                new ServiceCategory(null, "SOFTWARE_LICENSE", "Software license", null),
                new ServiceCategory(null, "SOFTWARE_SERVICES", "Software services", null),
                new ServiceCategory(null, "LABOUR", "Labour service provider", null),
                new ServiceCategory(null, "TURN_KEY", "Turn key projects", null),
                new ServiceCategory(null, "MANUFACTURER", "Manufacturer", null)
            ));
        }
    }
}
