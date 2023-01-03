package be.technifutur.decouverte.constructeur;

public class TestConstructeur {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class C extends B{
    int cpt;

    C(){
        super(getval());
        System.out.println("C.C");
        //text = "toto";
    }

    private static int getval() {
        return 5;
    }

    @Override
    public String toString() {
        return "C{" +
                "cpt=" + cpt +
                ", flag=" + flag +
                ", text='" + text + '\'' +
                '}';
    }
}

class B extends A{
    // début phase 3
    // à ce moment not et flag ont leur valeur par défaut
    // this existe
    boolean not = this.getFlag();
    boolean flag =true;

    private boolean getFlag() {
        System.out.println(flag);
        return  !flag;
    }

    {
        System.out.println("not: "+not);
    }

    B(int val){
        super(val);// 1er ligne
        System.out.println("B.B");
        this.text = "dede";
    }
}

class A{
    String text = "rené";
    //initialiseur d'instance
    {
        text = "Alain";
    }

    A(int val){
        //super(); // 1er ligne par défaut
        System.out.println("A.A");
        text = "lulu" + val;
    }

    A(){
        this(25);
        text = "benoit";
    }
}