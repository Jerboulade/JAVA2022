package be.technifutur.jcarere.mvc.repository;

import be.technifutur.jcarere.mvc.models.entity.Booking;

import java.time.Month;
import java.util.Set;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    Set<Booking> getFromMonth(Month month);

}
