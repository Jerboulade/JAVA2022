package be.technifutur.model.canard;

public class AlternateCancan implements ComportementDeCancan {

    private ComportementDeCancan cancan;
    private ComportementDeCancan cancan2;
    private boolean first = true;

    public AlternateCancan(ComportementDeCancan cancan, ComportementDeCancan cancan2) {
        this.cancan = cancan;
        this.cancan2 = cancan2;
    }


    @Override
    public void cancaner() {
        if (first)
            cancan.cancaner();
        else
            cancan2.cancaner();
        first = !first;
    }
}
