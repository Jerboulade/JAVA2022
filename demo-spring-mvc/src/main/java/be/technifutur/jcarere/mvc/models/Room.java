package be.technifutur.jcarere.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int     roomNumber;
    private int     roomSize;
    private int     nbSimpleBed;
    private int     nbDoubleBed;
    private Hotel   hotel;


}
