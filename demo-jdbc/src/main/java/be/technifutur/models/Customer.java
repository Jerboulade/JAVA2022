package be.technifutur.models;

import lombok.Data;

@Data
public class Customer {
    private String customerId;
    private String address;
    private String city;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String country;
    private String fax;
    private String phone;
    private String postalCode;
    private String region;
}
