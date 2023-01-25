package be.technifutur.jcarere.mvc.services;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.models.form.RoomForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service // condition (2) pour roomcontroller
public class RoomService {

    private final List<Room> roomList = new ArrayList<>();
    HotelService hotelService;

    public RoomService(HotelService hotelService){
        Hotel hotel;

        this.hotelService = hotelService;
        hotel = hotelService.getHotelByName("Campanil");
        roomList.add (new Room(UUID.randomUUID().toString(), 1, 10, 1, 0, hotel));
        roomList.add(new Room(UUID.randomUUID().toString(),2, 15, 0, 1, hotel));
        hotel = hotelService.getHotelByName("Ibis");
        roomList.add(new Room(UUID.randomUUID().toString(),3, 20, 1, 1, hotel));
        roomList.add(new Room(UUID.randomUUID().toString(),9, 30, 2, 1, hotel));
        hotel = hotelService.getHotelByName("Mariotte");
        roomList.add(new Room(UUID.randomUUID().toString(),3, 40, 1, 2, hotel));
        roomList.add(new Room(UUID.randomUUID().toString(),8, 40, 2, 2, hotel));
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

    public Room getOneById(String id){
        return roomList.stream()
                .filter(room -> room.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pas de chambre avec cet ID!"));
    }


    public List<Room> getRoomsByHotelName(String name){

        return roomList.stream()
                .filter(room -> room.getHotel().getName().equals(name))
                .toList();
    }

    public void insert(RoomForm form){
        Room room = new Room();

        room.setId(UUID.randomUUID().toString());
        room.setRoomSize(form.getRoomSize());
        room.setRoomNumber(form.getRoomNumber());
        room.setNbSimpleBed(form.getNbSimpleBed());
        room.setNbDoubleBed(form.getNbDoubleBed());
        System.out.println(form.getHotelId());
        room.setHotel(hotelService.getHotelByID(form.getHotelId()));
        roomList.add(room);
    }

    public void update(String id, RoomForm form){
        Room toUpdate = getOneById(id);

        toUpdate.setRoomNumber(form.getRoomNumber());
        toUpdate.setRoomSize(form.getRoomSize());
        toUpdate.setNbSimpleBed(form.getNbSimpleBed());
        toUpdate.setNbDoubleBed(form.getNbDoubleBed());
    }
}
