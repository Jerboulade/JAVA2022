package be.technifutur.jcarere.mvc.services;

import be.technifutur.jcarere.mvc.controllers.HotelController;
import be.technifutur.jcarere.mvc.models.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    private final List<Hotel> hotelList = new ArrayList<>();

    public HotelService(){
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Ibis", "Rue Blabla, 40", 3, 25, "Spirou"));
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Campanil", "Rue Pacherpacher, 28", 1, 10, "Lurch"));
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Mariotte", "Rue Onestbienbienbien, 115", 5, 125, "Alfred"));
    }

    public List<Hotel> getAll(){
        return new ArrayList<>(hotelList);
    }

    public Hotel getHotelByName(String name){
        return hotelList.stream()
                .filter(hotel -> hotel.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Ce nom d'hotel n'existe pas"));
    }
}
