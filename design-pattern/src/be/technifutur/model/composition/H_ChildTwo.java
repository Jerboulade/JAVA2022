package be.technifutur.model.composition;

public class H_ChildTwo extends H_Commun{
    //class qui incrémente de 1
    public int next() {
        inc(2);
        return getVal();
    }
}
