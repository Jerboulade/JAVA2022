package be.technifutur.jcarere.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String  id;
    private int     roomNumber;
    private int     roomSize;
    private int     nbSimpleBed;
    private int     nbDoubleBed;
    private Hotel   hotel;


    public Room(String id, int roomNumber, int roomSize, int nbSimpleBed, int nbDoubleBed, Hotel hotel) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.nbSimpleBed = nbSimpleBed;
        this.nbDoubleBed = nbDoubleBed;
        this.setHotel(hotel);
    }



    public void setHotel(Hotel hotel) {

        if(hotel != null && this.hotel != null)
            this.hotel.setRooms( hotel.getRooms()-1 );
        this.hotel = hotel;
        if(hotel != null)
            this.hotel.setRooms( hotel.getRooms()+1 );
    }
}
