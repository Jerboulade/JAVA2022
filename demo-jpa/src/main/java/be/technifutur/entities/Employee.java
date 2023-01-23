package be.technifutur.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @Column(name =      "employee_id")
    private long        employeeId;
    private String      address;
    @Column(name =      "birth_date")
    private LocalDate   birtDate;
    private String      city;
    private String      country;
    private String      extension;
    @Column(name =      "first_name")
    private String      firstName;
    @Column(name =      "hire_date")
    private LocalDate   hireDate;
    @Column(name =      "home_phone")
    private String      homePhone;
    @Column(name =      "last_name")
    private String      lastName;
    private String      notes;
    @Column(name =      "photo_path")
    private String      photoPath;
    @Column(name =      "postal_code")
    private String      postalCode;
    private String      region;

    @ManyToOne
    @JoinColumn(name =  "report_to")
    private Employee        reportTo;



    private String      title;
    @Column(name =      "title_of_courtesy")
    private String      titleOfCourtesy;

    @OneToMany(mappedBy = "employee_id")
    private Set<Order>  orders = new LinkedHashSet<>();

}
