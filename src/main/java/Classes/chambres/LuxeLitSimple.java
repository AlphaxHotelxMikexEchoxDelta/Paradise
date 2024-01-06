package Classes.chambres;

import Classes.chambres.Chambre;

import java.io.Serializable;

public class LuxeLitSimple extends Chambre implements Serializable {
    private int prix;
    public LuxeLitSimple (String nbChambre,String id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre de luxe lit simple:\t\t\t"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
