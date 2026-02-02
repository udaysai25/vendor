package com.example.vendormanagement.service;

import com.example.vendormanagement.dto.VendorRequestDto;
import com.example.vendormanagement.dto.VendorResponseDto;

import java.util.List;

public interface VendorService {

    VendorResponseDto addVendor(VendorRequestDto requestDto);

    VendorResponseDto updateVendor(Long id, VendorRequestDto requestDto);

    List<VendorResponseDto> getAllVendors();
}
