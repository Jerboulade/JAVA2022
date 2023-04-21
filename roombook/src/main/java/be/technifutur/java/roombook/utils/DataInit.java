package be.technifutur.java.roombook.utils;

import be.technifutur.java.roombook.models.entity.Room;
import be.technifutur.java.roombook.models.entity.User;
import be.technifutur.java.roombook.repositories.BookingRepository;
import be.technifutur.java.roombook.repositories.MaterialRepository;
import be.technifutur.java.roombook.repositories.RoomRepository;
import be.technifutur.java.roombook.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {

    private final RoomRepository roomRepository;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final MaterialRepository materialRepository;
    private final BookingRepository bookingRepository;

    public DataInit(RoomRepository roomRepository,
                    PasswordEncoder encoder, UserRepository userRepository,
                    MaterialRepository materialRepository,
                    BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.materialRepository = materialRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Room room = new Room();
        room.setCapacity(100);
        room.setNumber(101);
        roomRepository.save(room);

        room = new Room();
        room.setCapacity(200);
        room.setNumber(102);
        roomRepository.save(room);

        room = new Room();
        room.setCapacity(300);
        room.setNumber(103);
        roomRepository.save(room);

        User client = new User();
        client.setUsername("user");
        client.setPassword(encoder.encode("pass"));
        client.getRoles().add("USER");
        userRepository.save(client);

        client = new User();
        client.setUsername("admin");
        client.setPassword(encoder.encode("pass"));
        client.getRoles().add("ADMIN");
        userRepository.save(client);
    }
}