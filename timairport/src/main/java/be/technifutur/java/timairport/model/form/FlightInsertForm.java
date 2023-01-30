package be.technifutur.java.timairport.model.form;

import be.technifutur.java.timairport.model.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FlightInsertForm {
    /*
    Créer un vol:
    ------------

        * heure départ (future)
        * heure arrivé (après départ, max 2 jours)
        * airport départ (id)
        * airport arrivé (id, != airport départ)
        * capitaine (id) ( cap.company = plane.company )
        * firstOfficer (id, != capitaine)

    pour l'avion:
    -------------

        * le type d'avion souhaité (acceptable par les aéroports)
        * la company souhaitée (id)
        - pas en maintenance

    On préfère les avions présents, sinon,
    avion aléatoire possible.
    Si aucun avion possible, NoPlaneAvailableException
    */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Future
    private LocalDateTime departureTime;

    @NotNull
    @Future
    private LocalDateTime arrivalTime;

    @NotNull
    private UUID airport_departure;

    @NotNull
    private UUID airport_destination;

    @NotNull
    private UUID captain;

    @NotNull
    private UUID firstOfficer;

    @NotNull
    private PlaneForm plane;

    @Data
    public class PlaneForm {
        @NotNull
        private UUID id;

        @NotNull
        private UUID type;

        @NotNull
        private UUID wanted_company;
    }

    public Flight toEntity(){
        Flight entity = new Flight();

        entity.setDepartureTime(this.departureTime);
        entity.setArrivalTime(this.arrivalTime);

        return entity;
    }

}
