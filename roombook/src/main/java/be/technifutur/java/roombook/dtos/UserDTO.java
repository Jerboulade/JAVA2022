package be.technifutur.java.roombook.dtos;

import be.technifutur.java.roombook.models.entity.Booking;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class UserDTO {

    private UUID id;
    private String name;
    private String password;
    //private Set<String> roles;
    //private List<Booking> bookings;
}
