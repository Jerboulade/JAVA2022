package be.technifutur.models;

import lombok.Data;

@Data
public class Supplier {
    private long     supplierId;
    private String  address;
    private String  city;
    private String  companyName;
    private String  contactName;
    private String  contactTitle;
    private String  country;
    private String  fax;
    private String  homepage;
    private String  phone;
    private String  postalCode;
    private String  region;
}
