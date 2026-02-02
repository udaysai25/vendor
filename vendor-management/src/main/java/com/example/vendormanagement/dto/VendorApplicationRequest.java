package com.example.vendormanagement.dto;

import java.util.List;

@Data
public class VendorApplicationRequest {

    private String vendorName;
    private String legalName;
    private String businessJustification;
    private String requestingDepartment;

    private List<Long> serviceCategoryIds;

    public String getVendorName() { return vendorName; }
    public String getLegalName() { return legalName; }
    public String getBusinessJustification() { return businessJustification; }
    public String getRequestingDepartment() { return requestingDepartment; }
    public List<Long> getServiceCategoryIds() { return serviceCategoryIds; }
}