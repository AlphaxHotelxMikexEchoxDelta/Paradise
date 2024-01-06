package Classes;

public class LuxeLitDouble extends Chambre {
    private int prix;
    public LuxeLitDouble(int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre de luxe lit double:\t\t\t"+nbChambre+",prix: "+prix+"€\t\t"+", ["+statut()+"]";
    }
}
