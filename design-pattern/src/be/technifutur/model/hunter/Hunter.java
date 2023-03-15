package be.technifutur.model.hunter;

public class Hunter {

    public void hunt(Animal animal){
        System.out.println("PAN");
        animal.show();
        animal.scream();
        animal.flee();
    }
}
