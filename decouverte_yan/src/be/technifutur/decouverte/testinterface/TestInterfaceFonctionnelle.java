package be.technifutur.decouverte.testinterface;

import java.util.Comparator;

public class TestInterfaceFonctionnelle {

    public static void main(String[] args) {
        Mammifere toto = avecUneClasseAnonymeInterne();
        Mammifere dede = avecUneExpresssionLambda();
        Mammifere test = ()->TestInterfaceFonctionnelle.toto();
        test = TestInterfaceFonctionnelle::toto;

        System.out.println(test.identity());

        Comparator<String> monComparator = getCompatrator();

        monComparator.compare("toto","déde");

        System.out.println(toto.identity());
    }

    private static Comparator<String> getCompatrator() {
        return (i, j)-> i.compareTo(j);
    }

    private static Mammifere avecUneExpresssionLambda() {
        return ()->"je suis dédé";

    }

    public static Mammifere avecUneClasseAnonymeInterne(){
        return new Mammifere() {
            @Override
            public String identity() {
                return "je suis toto";
            }
        };
    }

    public Mammifere creeMoiUnMamifereAvecToto(){
        /*
        return new Mammifere() {
            @Override
            public String identity() {
                return TestInterfaceFonctionnelle.toto();
            }
        };*/
        return ()-> TestInterfaceFonctionnelle.toto();
    }

    static String toto(){
        return "blabla";
    }
}
