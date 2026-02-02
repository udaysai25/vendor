package com.example.vendormanagement.repository;

import com.example.vendormanagement.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
