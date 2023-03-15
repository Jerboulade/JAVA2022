package be.technifutur.model.canard;

public class NePasVoler implements ComportementDeVol{
    @Override
    public void vol() {
        System.out.println("Je ne vole pas");
    }
}
