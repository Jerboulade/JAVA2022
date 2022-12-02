package be.technifutur.decouverte.constructeur;

public class TestConstructeur {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class C extends B{
    int index;

    C(){
        super(getVal());
        System.out.println("C.C");
        str = "CouCou";
    }

    private static int getVal() {
        return 5;
    }

    @Override
    public String toString(){
        return "C{" +
                "cpt = " + index +
                ", flag = " + flag +
                ", str = " + str +
                '\'' + '}';
    }
}

class B extends A{
    // start phase 3
    // 'flag' et 'not' have default value
    // 'this' exists
    boolean not = this.getFlag();
    boolean flag = true;

    //  /!\  le compilateur va initialiser 'flag' (mais pas assigner)
    //       avant de passer dans la méthode getFlag.

    private boolean getFlag() {
        System.out.println("in getFlag flag = " + flag);
        return !flag;
    }

    {
        System.out.println("in classB, flag = " + flag);
        System.out.println("in classB, not = " + not);
    }
    B(int val){
        super(val);
        System.out.println("B.B");
        str = "BéBé";
    }
}

class A{
    String str = "AhAh";

    A(int val){
        System.out.println("A.A & val = " + String.valueOf(val));
    }
    A(){
        str = "AhAhAh";
    }
}
