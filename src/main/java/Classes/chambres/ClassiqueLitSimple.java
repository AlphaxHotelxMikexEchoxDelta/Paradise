package Classes.chambres;

import Classes.chambres.Chambre;

import java.io.Serializable;

public class ClassiqueLitSimple extends Chambre implements Serializable {
    private int prix;
    public ClassiqueLitSimple(String nbChambre,String id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Chambre classique lit simple:\tnumero chambre"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
