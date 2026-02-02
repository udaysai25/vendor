package com.example.vendormanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendormanagement.dto.VendorApplicationRequest;
import com.example.vendormanagement.entity.VendorApplication;
import com.example.vendormanagement.service.VendorApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendors")
public class VendorApplicationController {

    private final VendorApplicationService service;

    public VendorApplicationController(VendorApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createVendor(
            @RequestBody @Valid VendorApplicationRequest request) {

        return ResponseEntity.ok(service.createVendor(request));
    }
    @GetMapping
    public ResponseEntity<List<VendorApplication>> getAllVendors() {
        return ResponseEntity.ok(service.getAllVendors());
    }

}

