package be.technifutur.jcarere.mvc.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public class Contactable {

    private String  address;

    private String  phone;

    private String  mail;

}
