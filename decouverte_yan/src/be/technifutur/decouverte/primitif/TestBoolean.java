package be.technifutur.decouverte.primitif;

public class TestBoolean {
    public static void main(String[] args) {
        boolean b = true;
        boolean a = false;
        b = false;

        //int i = (int)b;
        // b = (boolean)0;

        //opérateur
        a = !b ;// not
        a = a & b ; // et évaluation longue
        a = a && b ; // et évaluation courte
        a = a | b ; // ou évaluation longue
        a = a || b ; // ou évaluation courte
        a = a ^ b ;// ou exclusif xor

        System.out.println(a?"toto":"dédé");

        Boolean test = Boolean.TRUE;

        a = test;
        test = a|b;

        Boolean.parseBoolean("true");

        int[] tab = {1,2};
        int i = 2;
        if(i< tab.length && tab[i]>1){
            System.out.println("coucou");
        }
        if(i< tab.length & tab[i]>1){
            System.out.println("dede");
        }

    }
}
