package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long        id;

    @OneToMany(mappedBy = "employee")
    private Set<WorkDetail> workDetailSet;
}
