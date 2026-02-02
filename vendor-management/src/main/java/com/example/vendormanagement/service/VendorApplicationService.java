package com.example.vendormanagement.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.vendormanagement.dto.VendorApplicationRequest;
import com.example.vendormanagement.entity.ServiceCategory;
import com.example.vendormanagement.entity.VendorApplication;
import com.example.vendormanagement.repository.ServiceCategoryRepository;
import com.example.vendormanagement.repository.VendorApplicationRepository;

import jakarta.transaction.Transactional;

@Service
public class VendorApplicationService {

    private final VendorApplicationRepository vendorRepo;
    private final ServiceCategoryRepository serviceRepo;

    public VendorApplicationService(VendorApplicationRepository vendorRepo, ServiceCategoryRepository serviceRepo) {
        this.vendorRepo = vendorRepo;
        this.serviceRepo = serviceRepo;
    }

    @Transactional
    public VendorApplication createVendor(VendorApplicationRequest request) {

        VendorApplication vendor = new VendorApplication();
        vendor.setVendorName(request.getVendorName());
        vendor.setLegalName(request.getLegalName());
        vendor.setBusinessJustification(request.getBusinessJustification());
        vendor.setRequestingDepartment(request.getRequestingDepartment());

        Set<ServiceCategory> services =
                new HashSet<>(serviceRepo.findAllById(request.getServiceCategoryIds()));

        if (services.isEmpty()) {
            throw new IllegalArgumentException("At least one service category must be selected");
        }

        vendor.setServiceCategories(services);

        return vendorRepo.save(vendor);
    }

    public java.util.List<VendorApplication> getAllVendors() {
        return vendorRepo.findAll();
    }
}
