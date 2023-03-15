import be.technifutur.model.canard.*;
import be.technifutur.model.hunter.CanardAdapter;
import be.technifutur.model.hunter.Hunter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CanardStrategy> mare = Arrays.asList(
                new Colvert(),
                new Mandarin(),
                new CanardPlastique(),
                new Leurre()
        );
        Hunter hunter = new Hunter();
        for (CanardStrategy c : mare){
            c.afficher();
            c.nager();
            //c.setCancan(new Begayer(new Begayer(new AlternateCancan( c.getCancan(), ()->{System.out.println("lambda lambda!");}))));
            c.effectuerCanCan();
            c.effectuerVol();
            System.out.println("---CHASSE---");
            CanardAdapter hunted = new CanardAdapter(c);
            hunter.hunt(hunted);
            System.out.println("--------------");


        }
    }
}