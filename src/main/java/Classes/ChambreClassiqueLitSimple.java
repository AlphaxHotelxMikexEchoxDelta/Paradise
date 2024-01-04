package Classes;

public class ChambreClassiqueLitSimple extends Chambre {
    private int prix;
    public ChambreClassiqueLitSimple(int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre classique lit simple: "+nbChambre+",prix: "+prix+"€"+", statut: "+statut(occupe);
    }
}