package Classes;

public class LuxeLitSimple extends Chambre {
    private int prix;
    public LuxeLitSimple (int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre de luxe lit simple:\t\t\t"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
