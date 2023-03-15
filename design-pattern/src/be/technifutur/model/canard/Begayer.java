package be.technifutur.model.canard;

public class Begayer implements ComportementDeCancan {

    private ComportementDeCancan cancan;

    public Begayer(ComportementDeCancan cancan) {
        this.cancan = cancan;
    }


    @Override
    public void cancaner() {
        cancan.cancaner();
        cancan.cancaner();
    }
}
