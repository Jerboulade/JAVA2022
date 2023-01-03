package be.technifutur.decouverte.statement;

public class DecouverteAlternativeEtBoucle {

    public static void main(String[] args) {
        //if(expression boolean) 1 instruction [else 1 instruction];
        // {....} 1 instruction

//        int test = 4;
//        if (test > 5) {
//            if (test < 8)
//                System.out.println("entre 5 et 8");
//        } else
//            System.out.println("toto");
//
//        if (test == 1) {
//            System.out.println(1);
//        } else if (test == 2) {
//            System.out.println(2);
//        } else if (test == 3) {
//            System.out.println(3);
//        } else {
//            System.out.println("autre");
//        }
        testSwitch();
        testWhile();
    }

    static void testSwitch() {
        int test = 1;
        switch (test) {
            case 1:
                System.out.println(1);
                break;
            case 2:
            case 4:
            case 6:
            case 8:
                System.out.println("paire");
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("autre");
                break;
        }
        int a = 5;
        final int val = 22;

        int result = switch (test) {
            case 2, 3, 5, 6 -> 5;
            case 7 -> 8;
            case 8 -> {
                System.out.println("toto");
                yield 10;
                //System.out.println("dede");
            }
            case val -> 22;
            default -> 0;
        };
        int result2 = 0;


        switch (test) {
            case 2, 3, 5, 6 -> result2 = 5;
            case 7 -> result2 = 8;
            case 8 -> {
                System.out.println("toto");
                result2 = 10;
                //System.out.println("dede");
            }
            //default -> result2 = 0;
        }
        ;
    }

    static void testWhile() {
        //while(expressionBoolean) 1 instruction

        int cpt = 0;
        while (cpt < 10) {
            System.out.println(cpt);
            cpt = cpt + 1;
        }

        do {
            System.out.println(cpt);
            cpt = cpt - 1;
        } while (cpt > 0);
    }

    static void testfor() {
        int i = 0;
        for (; i < 10; ) {
            System.out.println("coucou");
            i = i + 1;
        }
        System.out.println(i);

        String t = "KAYAK";
        boolean palindrome = true;
        for (int d = 0, f = t.length() - 1; d < f && palindrome; d = d + 1, f = f - 1) {
            palindrome = t.charAt(d) == t.charAt(f);
        }

        int[] tab = {1,5,8,9};

        for(int val : tab){
            System.out.println(val);
        }

        int[][] tab2d = {{1,2},{5,6}};

        for(int[] t2 :tab2d){
            for(int i2 : t2){

            }
        }
    }
}
