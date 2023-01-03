package be.technifutur.decouverte.poo;

public class Scenario4 {

    public static void main(String[] args) {
        Personnage[] pers = {
                new Soldat("Léon"),
                new Jedi("Luc"),
                new Sith("Dravador"),
                new Clone(),
                new Clone("Alfred")
        };
        Force toto;

        for(Personnage p : pers){
            System.out.println(p.getNom());
            if(p instanceof Force){
                toto = (Force) p;
                toto.utiliserForce();
            }
            p.afficheCamps();
            p.combattre();
        }


    }
}
