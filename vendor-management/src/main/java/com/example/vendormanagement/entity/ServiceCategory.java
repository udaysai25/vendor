package com.example.vendormanagement.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_category")
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToMany(mappedBy = "serviceCategories")
    private Set<VendorApplication> vendorApplications = new HashSet<>();

    public ServiceCategory() {}

    public ServiceCategory(Long id, String code, String name, Set<VendorApplication> vendorApplications) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.vendorApplications = vendorApplications == null ? new HashSet<>() : vendorApplications;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Set<VendorApplication> getVendorApplications() { return vendorApplications; }
    public void setVendorApplications(Set<VendorApplication> vendorApplications) { this.vendorApplications = vendorApplications; }

}


