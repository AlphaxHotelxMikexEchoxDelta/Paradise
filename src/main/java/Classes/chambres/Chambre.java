package Classes.chambres;

import java.io.Serializable;

public class Chambre implements Serializable {


    protected String nbChambre;
    protected boolean occupe;
    protected String id;

    public Chambre(String nbChambre,String id,boolean occupe){
        this.nbChambre=nbChambre;
        this.id=id;
        this.occupe=occupe;
    }

    public String getId() {
        return id;
    }
    public String getNbChambre() {
        return nbChambre;
    }

    public void setStatus( boolean i ){
        this.occupe = i ;
    }

    public int getPrix() { return 0 ; }

    public String statut(){
        if (!this.occupe){
            return "Libre";
        }
        else{
            return "Occuper";
        }
    }

}
