package be.technifutur.jcarere.mvc;

import be.technifutur.jcarere.mvc.models.entity.Booking;
import be.technifutur.jcarere.mvc.repository.CrudRepository;
import be.technifutur.jcarere.mvc.repository.impl.BookingRepositoryImpl;
import be.technifutur.jcarere.mvc.repository.interfaces.BookingRepository;
import be.technifutur.jcarere.mvc.utils.EMFSharer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(DemoSpringMvcApplication.class, args);
		BookingRepository bookingRepository = context.getBean(BookingRepository.class);


		List<Booking> list = null;
		try{
			list = bookingRepository.getAll();
			//list = bookingRepository.getFromMonth(Month.SEPTEMBER, 2023);
			list.forEach(book -> {
				System.out.printf("----- %s -----\n", book);
				System.out.printf("%-16s : %d\n", 	"Id", 				book.getId());
				System.out.printf("%-16s : %s\n", 	"Start", 			book.getStart());
				System.out.printf("%-16s : %s\n", 	"End", 				book.getEnd());
				System.out.printf("%-16s : %b\n", 	"Breakfast", 		book.isBreakfast());
				System.out.printf("%-16s : %s\n", 	"Customer name", 	book.getCustomer().getFirstName());
				System.out.printf("%-16s : %d\n", 	"Customer id", 		book.getCustomer().getId());
				System.out.printf("%-16s : %d\n", 	"Room nb",			book.getRoom().getNumber());
				System.out.printf("%-16s : %d\n", 	"Room id",			book.getRoom().getId());
			});

			//int nbBreakfast = bookingRepository.getBreakFastNeededForDay(LocalDate.of(2023, 10, 5));
			//System.out.printf("\nNumber of breakfast : \n", nbBreakfast);
		}
		catch (Exception e) {
			System.out.println("Et merde! \n" + e.getMessage() + "\n");
		}
		context.getBean(EMFSharer.class).close();
	}

}
