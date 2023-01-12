package be.technifutur.jcarere.mvc.services;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // condition (2) pour roomcontroller
public class RoomService {

    private final List<Room> roomList = new ArrayList<>();

    public RoomService(HotelService hotelService){
        roomList.add (new Room(1, 10, 1, 0, hotelService.getHotelByName("Campanil")));
        roomList.add(new Room(2, 15, 0, 1, hotelService.getHotelByName("Campanil")));
        roomList.add(new Room(3, 20, 1, 1, hotelService.getHotelByName("Ibis")));
        roomList.add(new Room(3, 30, 2, 1, hotelService.getHotelByName("Ibis")));
        roomList.add(new Room(4, 40, 1, 2, hotelService.getHotelByName("Mariotte")));
        roomList.add(new Room(4, 40, 2, 2, hotelService.getHotelByName("Mariotte")));
    }

    public List<Room> getAll(){
        return new ArrayList<>(roomList);
    }

    public Room getOne(int numRoom){
        return roomList.stream()
                .filter(room -> room.getRoomNumber() == numRoom)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pas de chambre avec ce numéro!"));
    }
}
