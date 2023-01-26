package be.technifutur.jcarere.mvc.utils;

import be.technifutur.jcarere.mvc.models.entity.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInit implements InitializingBean {

    private final EntityManager manager;

    public DataInit(EMFSharer emfSharer) {
        this.manager = emfSharer.createEntityManager();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        manager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("luc");
        employee.setLastName("dubois");
        employee.setAddress("une adresse");
        employee.setMail("@.com");
        employee.setPhone("000");

        employee = manager.merge(employee);

        Hotel hotel = new Hotel();

        hotel.setId(1L);
        hotel.setAddress("adress");
        hotel.setMail("email");
        hotel.setPhone("phone");
        hotel.setName("Mercure");
        hotel.setStars((short) 2);
        hotel.setGroom(employee);

        hotel = manager.merge( hotel );

        Room room = new Room();
        room.setId(2L);
        room.setSize(10);
        room.setHotel(hotel);
        room.setAvailable(true);
        room.setDoubleBed(1);
        room.setNumber(101);
        room.setFloor(1);
        room.setType(RoomType.BASIC);
        room.setView(RoomView.AVERAGE);

        manager.merge( room );

        Customer user = new Customer();

        user.setId(2L);
        user.setUserName("user");
        user.setPassword("pass");
        user.setRole("customer");
        user.setAddress("adresse");
        user.setMail("email");
        user.setPhone("phone");
        user.setFirstName("luc");
        user.setLastName("dubois");

        manager.merge(user);

        Booking reservation = new Booking();

        reservation.setId(1L);
        reservation.setStart(LocalDateTime.of(2023, 10, 29,12,0,0));
        reservation.setEnd(LocalDateTime.of(2023, 11, 02,12,0,0));
        reservation.setRoom(room);
        reservation.setCustomer(user);
        reservation.setPrice(100);
        reservation.setBreakfast(true);
        reservation.setCreatedAt(LocalDateTime.now());

        manager.merge(reservation);

        reservation = new Booking();

        reservation.setId(2L);
        reservation.setStart(LocalDateTime.of(2023, 9, 30,12,0,0));
        reservation.setEnd(LocalDateTime.of(2023, 10, 3,12,0,0));
        reservation.setRoom(room);
        reservation.setCustomer(user);
        reservation.setPrice(100);
        reservation.setBreakfast(true);
        reservation.setCreatedAt(LocalDateTime.now());

        manager.merge(reservation);


        reservation = new Booking();

        reservation.setId(3L);
        reservation.setStart(LocalDateTime.of(2023, 10, 3,12,0,0));
        reservation.setEnd(LocalDateTime.of(2023, 10, 30,12,0,0));
        reservation.setRoom(room);
        reservation.setCustomer(user);
        reservation.setPrice(100);
        reservation.setBreakfast(false);
        reservation.setCreatedAt(LocalDateTime.now());

        manager.merge(reservation);

        manager.getTransaction().commit();

    }
}
