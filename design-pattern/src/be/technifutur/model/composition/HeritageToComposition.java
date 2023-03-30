package be.technifutur.model.composition;

public class HeritageToComposition {
    // H_ --> pour héritage
    // C_ --> pour composition

    public static void main(String[] args) {
        heritage();
    }

    private static void heritage() {
        H_ChildOne one = new H_ChildOne();
        H_ChildTwo two = new H_ChildTwo();

        System.out.println(one.getVal());
        System.out.println(one.next());
        System.out.println(one.getVal());

        System.out.println(two.getVal());
        System.out.println(two.next());
        System.out.println(two.getVal());
    }

    private static void composition() {
        C_ChildOne one = new C_ChildOne();
        C_ChildTwo two = new C_ChildTwo();

        System.out.println(one.getVal());
        System.out.println(one.next());
        System.out.println(one.getVal());

        System.out.println(two.getVal());
        System.out.println(two.next());
        System.out.println(two.getVal());
    }
}
