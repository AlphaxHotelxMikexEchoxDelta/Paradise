package Classes;

public class ChambreDeLuxeLitDouble extends Chambre {
    private int prix;
    public ChambreDeLuxeLitDouble(int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre de luxe lit double: "+nbChambre+",prix: "+prix+"€"+", statut: "+statut(occupe);
    }
}
