package be.technifutur.jcarere.mvc.repository;

import be.technifutur.jcarere.mvc.models.entity.Booking;
import be.technifutur.jcarere.mvc.utils.EMFSharer;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.time.Month;
import java.util.Set;

@Repository
public class BookingRepositoryImpl extends AbstractCrudRepository<Booking, Long> implements BookingRepository {

    protected BookingRepositoryImpl(EMFSharer emfSharer) {
        super(Booking.class, emfSharer.createEntityManager());
    }

    @Override
    public void adaptId(Long id, Booking entity) {
        entity.setId(id);
    }

    @Override
    public Set<Booking> getFromMonth(Month month) {
        return null;
    }
}
