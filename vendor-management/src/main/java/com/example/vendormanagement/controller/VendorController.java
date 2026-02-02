package com.example.vendormanagement.controller;

import com.example.vendormanagement.dto.VendorRequestDto;
import com.example.vendormanagement.dto.VendorResponseDto;
import com.example.vendormanagement.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<VendorResponseDto> addVendor(
            @RequestBody VendorRequestDto requestDto) {
        return ResponseEntity.ok(vendorService.addVendor(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorResponseDto> updateVendor(
            @PathVariable Long id,
            @RequestBody VendorRequestDto requestDto) {
        return ResponseEntity.ok(vendorService.updateVendor(id, requestDto));
    }

    @GetMapping
    public ResponseEntity<List<VendorResponseDto>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }
}
