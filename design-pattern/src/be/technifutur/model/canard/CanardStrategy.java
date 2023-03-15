package be.technifutur.model.canard;

public abstract class CanardStrategy{

    private ComportementDeVol vol;
    private ComportementDeCancan cancan;
    public CanardStrategy(ComportementDeVol vol, ComportementDeCancan cancan) {
        this.vol = vol;
        this.cancan = cancan;
    }

    public void setVol(ComportementDeVol vol) {
        this.vol = vol;
    }
    public void setCancan(ComportementDeCancan cancan) {
        this.cancan = cancan;
    }

    public ComportementDeCancan getCancan() {
        return cancan;
    }

    public ComportementDeVol getVol() {
        return vol;
    }
    public abstract void afficher();


    public abstract void nager();

    public void effectuerCanCan(){
        cancan.cancaner();
    }

    public void effectuerVol(){
        vol.vol();
    }
}
