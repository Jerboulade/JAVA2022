package be.technifutur.decouverte.generique;

public class Box <E>{

    private E value;

    public Box(E val){
        this.value = val;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
