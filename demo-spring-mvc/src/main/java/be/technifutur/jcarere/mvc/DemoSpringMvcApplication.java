package be.technifutur.jcarere.mvc;

import be.technifutur.jcarere.mvc.utils.EMFSharer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(DemoSpringMvcApplication.class, args);

		context.getBean(EMFSharer.class).close();
	}

}
