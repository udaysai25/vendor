package com.example.vendormanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendormanagement.entity.ServiceCategory;
import com.example.vendormanagement.repository.ServiceCategoryRepository;

@RestController
@RequestMapping("/api/service-categories")
public class ServiceCategoryController {

    private final ServiceCategoryRepository repo;

    public ServiceCategoryController(ServiceCategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ServiceCategory> getAll() {
        return repo.findByActiveTrue();
    }
}

