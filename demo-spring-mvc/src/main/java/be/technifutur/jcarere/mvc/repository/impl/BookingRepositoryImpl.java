package be.technifutur.jcarere.mvc.repository.impl;

import be.technifutur.jcarere.mvc.models.entity.Booking;
import be.technifutur.jcarere.mvc.repository.AbstractCrudRepository;
import be.technifutur.jcarere.mvc.repository.interfaces.BookingRepository;
import be.technifutur.jcarere.mvc.utils.EMFSharer;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Set;

@Repository
public class BookingRepositoryImpl extends AbstractCrudRepository<Booking, Long> implements BookingRepository {

    protected BookingRepositoryImpl(EMFSharer emfSharer) {
        super(Booking.class, emfSharer.createEntityManager());
    }


    @Override
    public List<Booking> getFromMonth(Month month, int year) {
        LocalDateTime start = LocalDateTime.of(year, month,1, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, month, month.length(Year.isLeap(year)), 23, 59);
        String qlQuery = "SELECT b FROM Booking b WHERE b.start <= ?2 AND b.end >= ?1";
        TypedQuery<Booking> query = entityManager.createQuery(qlQuery, Booking.class);

        query.setParameter(1, start);
        query.setParameter(2, end);

        List<Booking> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public int getBreakFastNeededForDay(LocalDate date) {
        int nbBreakFast = 0;
        if (!date.isBefore(LocalDate.now()))
        {
            String qlQuery = "SELECT sum(b.additionalBed + (b.room.doubleBed * 2) + b.room.simpleBed) " +
                    "FROM Booking b " +
                    "WHERE ?1 BETWEEN (b.start AND b.end) " +
                    "AND b.breakfast";
            TypedQuery<Integer> query = entityManager.createQuery(qlQuery, Integer.class);

            query.setParameter(1, date);

            nbBreakFast = query.getSingleResult();
        }
        return nbBreakFast;
    }

    @Override
    public List<Booking> getFutureShortReservation() {
        String qlQuery = "SELECT b FROM Booking b " +
                "WHERE b.start >= now()" +
                "AND extract(DAY from b.end - b.start)";
        TypedQuery<Booking> query = entityManager.createQuery(qlQuery, Booking.class);

        query.setParameter(1, LocalDateTime.now());

        List<Booking> list = query.getResultList();
        entityManager.clear();

        return list;
    }

    @Override
    public Set<Booking> getFutureLongReservation() {
        return null;
    }
}
