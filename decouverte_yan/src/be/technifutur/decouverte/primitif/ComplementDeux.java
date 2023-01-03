package be.technifutur.decouverte.primitif;

public class ComplementDeux {

    public static final int CTRL = 0b1;
    public static final int MAJ = 0b10;
    public static final int ALT = 0b100;
    public static final int WIN = 0b1000;
    public static void main(String[] args) {
        int i = 5;
        int j  = ~i + 1; //-5
        int k = ~j + 1; // 5
        System.out.println(i);
        System.out.println(Integer.toBinaryString(j));
        System.out.println(k);

        System.out.println(j>>2);
        System.out.println(j>>>2);

        isAltCtrl(0b0011);//false
        isAltCtrl(0b0111);//true
    }

    static boolean isAltCtrl(int val){
        int mask = ALT|CTRL;
        return (val & mask) == mask;
    }
}
