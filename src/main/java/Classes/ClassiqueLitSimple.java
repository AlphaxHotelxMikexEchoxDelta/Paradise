package Classes;

public class ClassiqueLitSimple extends Chambre {
    private int prix;
    public ClassiqueLitSimple(int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre classique lit simple:\t\t\t"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
