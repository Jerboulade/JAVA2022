package be.technifutur.decouverte.primitif;

import java.math.BigInteger;

public class PlusieursValeursDansUnInt {

    public static void main(String[] args) {
        /*int val = 4;
        val = (val<<4) + 6;
        val = (val<<4) + 0;
        val = (val<<4) + 5;

        int mask = 0b1111;
        System.out.println(val & mask);
        val >>>=4; //val = val >>> 4
        System.out.println(val & mask);
        val >>>=4; //val = val >>> 4
        System.out.println(val & mask);
        val >>>=4; //val = val >>> 4
        System.out.println(val & mask);
        val >>>=4; //val = val >>> 4*/


        BigInteger val = new BigInteger("4");
        val = val.shiftLeft(4).add(new BigInteger("6"));
        val = val.shiftLeft(4).add(new BigInteger("0"));
        val = val.shiftLeft(4).add(new BigInteger("5"));
        val = val.shiftLeft(4).add(new BigInteger("6"));
        val = val.shiftLeft(4).add(new BigInteger("0"));
        val = val.shiftLeft(4).add(new BigInteger("5"));

        BigInteger mask = new BigInteger(""+0b1111);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);
        System.out.println(val.and(mask));
        val = val.shiftRight(4);

    }
}
