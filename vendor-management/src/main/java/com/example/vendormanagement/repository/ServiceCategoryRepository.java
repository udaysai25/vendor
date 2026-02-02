package com.example.vendormanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendormanagement.entity.ServiceCategory;

public interface ServiceCategoryRepository
        extends JpaRepository<ServiceCategory, Long> {

    List<ServiceCategory> findByActiveTrue();
}

