package be.technifutur.jcarere.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String  id;
    private String  name;
    private String  address;
    private int     stars;
    private int     rooms;
    private String  groom;
}
