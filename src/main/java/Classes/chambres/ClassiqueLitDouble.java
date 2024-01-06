package Classes.chambres;

import java.io.Serializable;

public class ClassiqueLitDouble extends Chambre implements Serializable {
    private int prix;
    public ClassiqueLitDouble(String nbChambre,String id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre classique lit Double:\t\t\t"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
