package Classes;

public class Chambre {


    protected int nbChambre;
    protected boolean occupe;
    protected int id;

    public Chambre(int nbChambre,int id,boolean occupe){
        this.nbChambre=nbChambre;
        this.id=id;
        this.occupe=occupe;
    }

    public int getId() {
        return id;
    }

    public String statut(){
        if (!this.occupe){
            return "Libre";
        }
        else{
            return "Occuper";
        }
    }

}
