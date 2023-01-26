package be.technifutur.jcarere.mvc.repository.interfaces;

import be.technifutur.jcarere.mvc.models.entity.Booking;
import be.technifutur.jcarere.mvc.repository.CrudRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    /**
     * Gets the reservation that begins or ends in a month
     * @param month
     * @param year
     * @return the set of reservation for a specific month
     */
    List<Booking> getFromMonth(Month month, int year);

    /**
     * Gets the number of breakfast that should be prepared for a day
     * @param day
     * @return the number of breakfast
     */
    int getBreakFastNeededForDay(LocalDate day);

    /**
     * Gets the reservation that begins in the future and last less than a week
     * @return a Set of reservation
     */
    List<Booking> getFutureShortReservation();

    /**
     * Gets the reservation that begins in the future and last a week or more
     * @return
     */
    Set<Booking> getFutureLongReservation();

}
