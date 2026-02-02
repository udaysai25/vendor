package com.example.vendormanagement.service.impl;

import com.example.vendormanagement.dto.VendorRequestDto;
import com.example.vendormanagement.dto.VendorResponseDto;
import com.example.vendormanagement.entity.Vendor;
import com.example.vendormanagement.enums.VendorStatus;
import com.example.vendormanagement.exception.ResourceNotFoundException;
import com.example.vendormanagement.repository.VendorRepository;
import com.example.vendormanagement.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorResponseDto addVendor(VendorRequestDto requestDto) {
        Vendor vendor = new Vendor();
        vendor.setName(requestDto.getName());
        vendor.setEmail(requestDto.getEmail());
        vendor.setStatus(
            VendorStatus.valueOf(requestDto.getStatus().toUpperCase())
        );

        Vendor saved = vendorRepository.save(vendor);
        return mapToResponse(saved);
    }

    @Override
    public VendorResponseDto updateVendor(Long id, VendorRequestDto requestDto) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        vendor.setName(requestDto.getName());
        vendor.setEmail(requestDto.getEmail());
        vendor.setStatus(
            VendorStatus.valueOf(requestDto.getStatus().toUpperCase())
        );

        return mapToResponse(vendorRepository.save(vendor));
    }

    @Override
    public List<VendorResponseDto> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private VendorResponseDto mapToResponse(Vendor vendor) {
        VendorResponseDto dto = new VendorResponseDto();
        dto.setId(vendor.getId());
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setStatus(vendor.getStatus());
        return dto;
    }
}
