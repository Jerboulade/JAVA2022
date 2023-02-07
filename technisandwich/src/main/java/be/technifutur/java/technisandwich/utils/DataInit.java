package be.technifutur.java.technisandwich.utils;

import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements InitializingBean {

    private final SandwichRepository  sandwichRepository;

    public DataInit(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Sandwich sandwich = new Sandwich();
        sandwich.setName("Dagobert");
        sandwich.setPrice(4.5f);
        sandwich.setDescription("Miam!");
        sandwichRepository.save(sandwich);

        Sandwich sandwich2 = new Sandwich();
        sandwich2.setName("Poulet Curry");
        sandwich2.setPrice(4.f);
        sandwich2.setDescription("Kotkotkot");
        sandwichRepository.save(sandwich2);
    }
}
