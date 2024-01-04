package Classes;

public class ChambreDeLuxeLitSimple extends Chambre {
    private int prix;
    public ChambreDeLuxeLitSimple (int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre de luxe lit simple: "+nbChambre+",prix: "+prix+"€"+", statut: "+statut(occupe);
    }
}