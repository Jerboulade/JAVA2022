package be.technifutur.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "territories")
public class Territory {
    @Id
    @Column(name =  "territory_id")
    private String  territoryId;
    @ManyToOne
    @JoinColumn(name =  "region_id")
    private Region    regionID;
    @Column(name =  "territory_description")
    private String  territoryDescription;



}
