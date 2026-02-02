package com.example.vendormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendormanagement.entity.VendorApplication;

public interface VendorApplicationRepository 
        extends JpaRepository<VendorApplication, Long> {
}
