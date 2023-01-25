package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class WorkDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_detail_id")
    private Long        id;

    @Column(name = "date_start", nullable = false)
    private LocalDate   dateStart;

    @Column(name = "date_end")
    private LocalDate   dateEnd;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel       hotel;

    @ManyToOne
    @JoinColumn (name = "employee_id", nullable = false)
    private Employee    employee;
}
