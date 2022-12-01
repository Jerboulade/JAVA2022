package be.technifutur.decouverte.poo;

public class Millenium extends VaisseauAncetre
{
    public Millenium()
    {
        // super(); pas obligatoire -->call to constructeur VaisseauAncetre()
        // si contructeur du parent contient des paramatres par default :
        super(20);
    }

    @Override
    public void showAffiliation(){
        System.out.println("I belong to the Rebellion");
    }

    @Override
    public void shoot(){
        super.shoot();
        //if (this.nbRocket > 0) -->does't work because nbRocket is private
        super.shoot();
    }

    @Override
    public String toString(){
        return ("toString has been overriden");
    }

    public void lightSpeed(){
        System.out.println("Light speed ON");
    }
}
