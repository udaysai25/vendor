package com.example.vendormanagement.mapper;

import com.example.vendormanagement.dto.VendorRequestDto;
import com.example.vendormanagement.dto.VendorResponseDto;
import com.example.vendormanagement.entity.Vendor;
import com.example.vendormanagement.enums.VendorStatus;

public class VendorMapper {

    public static Vendor toEntity(VendorRequestDto dto) {
        Vendor vendor = new Vendor();
        vendor.setName(dto.getName());
        vendor.setEmail(dto.getEmail());
        vendor.setStatus(VendorStatus.ACTIVE);
        return vendor;
    }

    public static VendorResponseDto toDto(Vendor vendor) {
        VendorResponseDto dto = new VendorResponseDto();
        dto.setId(vendor.getId());
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setStatus(vendor.getStatus());
        return dto;
    }
}
