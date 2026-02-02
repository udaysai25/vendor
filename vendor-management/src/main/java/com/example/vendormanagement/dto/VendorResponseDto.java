package com.example.vendormanagement.dto;

import com.example.vendormanagement.enums.VendorStatus;

public class VendorResponseDto {

    private Long id;
    private String name;
    private String email;
    private VendorStatus status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public VendorStatus getStatus() { return status; }
    public void setStatus(VendorStatus status) { this.status = status; }
}
