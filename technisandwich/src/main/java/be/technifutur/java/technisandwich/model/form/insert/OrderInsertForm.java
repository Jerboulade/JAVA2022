package be.technifutur.java.technisandwich.model.form.insert;

import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class OrderInsertForm {

    private LocalDate       deliveryDate;
    private List<Long>      sandwiches_id;
}
