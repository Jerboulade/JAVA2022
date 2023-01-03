package be.technifutur.decouverte.testinterface;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Chat();

        //animal.identity();

        Animal.methodeStatic();

        Mammifere mammifere = new Chat();

        Aquatique poisson = new PoissonRouge();

        System.out.println(animal.type());
        System.out.println(mammifere.type());
        System.out.println(poisson.type());

    }
}
