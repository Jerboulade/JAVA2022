package be.technifutur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "suppliers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @Column(name = "supplier_id")
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_title")
    private String contactTitle;

    private String address;

    private String city;

    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    private String fax;

    private String phone;

    private String homepage;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}