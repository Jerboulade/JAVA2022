package be.technifutur.jcarere.mvc.services;

import be.technifutur.jcarere.mvc.controllers.HotelController;
import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.models.HotelForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    private final List<Hotel> hotelList = new ArrayList<>();

    public HotelService(){
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Ibis", "Rue Blabla, 40", 3, 0, "Spirou"));
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Campanil", "Rue Pacherpacher, 28", 1, 0, "Lurch"));
        hotelList.add(new Hotel(UUID.randomUUID().toString(), "Mariotte", "Rue Onestbienbienbien, 115", 5, 0, "Alfred"));
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

    public Hotel getHotelByID(String id){
        return hotelList.stream()
                .filter(hotel -> hotel.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cet hotel n'existe pas"));
    }

    public void createHotel(HotelForm form){
        Hotel hotel = new Hotel();

        hotel.setId(form.getId());
        hotel.setName(form.getName());
        hotel.setStars(form.getStars());
        hotel.setGroom(form.getGroom());
        hotel.setAddress(form.getAddress());
        hotelList.add(hotel);
    }
}
