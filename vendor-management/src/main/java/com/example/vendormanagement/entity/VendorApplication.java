package com.example.vendormanagement.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_application")
public class VendorApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vendorName;

    private String legalName;

    @Column(length = 250)
    private String businessJustification;

    @Column(nullable = false)
    private String requestingDepartment;

    @ManyToMany
    @JoinTable(
        name = "vendor_service_mapping",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<ServiceCategory> serviceCategories = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getLegalName() { return legalName; }
    public void setLegalName(String legalName) { this.legalName = legalName; }

    public String getBusinessJustification() { return businessJustification; }
    public void setBusinessJustification(String businessJustification) { this.businessJustification = businessJustification; }

    public String getRequestingDepartment() { return requestingDepartment; }
    public void setRequestingDepartment(String requestingDepartment) { this.requestingDepartment = requestingDepartment; }

    public Set<ServiceCategory> getServiceCategories() { return serviceCategories; }
    public void setServiceCategories(Set<ServiceCategory> serviceCategories) { this.serviceCategories = serviceCategories; }
}
