package Classes;

public class ClassiqueLitDouble extends Chambre {
    private int prix;
    public ChambreClassiqueLitDouble(int nbChambre,int id,boolean occupe,int prix){
        super(nbChambre,id,occupe);
        this.prix=prix;
    }


    @Override
    public String toString() {
        return "Chambre classique lit Double: "+nbChambre+",prix: "+prix+"€"+", statut: "+statut(occupe);
    }
}
