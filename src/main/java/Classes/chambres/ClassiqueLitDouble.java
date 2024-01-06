package Classes.chambres;

import java.io.Serializable;

public class ClassiqueLitDouble extends Chambre implements Serializable {
    private int prix;
    public ClassiqueLitDouble(String nbChambre,String id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Chambre classique lit Double:\tnumero chambre"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
