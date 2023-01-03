package be.technifutur.decouverte.primitif;

public class TestBinaire {

    public static void main(String[] args) {
        int i = 0b1100110;
        System.out.println(Integer.toBinaryString(i));
        i = i<<2;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        i = i>>2;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        i = i>>2;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        int j = 0b11100;
        System.out.println(Integer.toBinaryString(j));
        i = i & j;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

        i = i|j;
        i = i^j;
        i = ~j;

    }
}
