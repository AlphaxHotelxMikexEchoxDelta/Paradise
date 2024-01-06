package Classes.hotel;
import Classes.chambres.Chambre;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {

    protected String nom ;
    protected int nbEtoile, nbClient, nbChambre ;
    protected ArrayList<Chambre> chambres ;

    public Hotel(String nom,int nbEtoile,int nbChambre,ArrayList<Chambre> chambres) {
        this.nom = nom;
        this.nbEtoile = nbEtoile;
        this.nbChambre = nbChambre;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }
}
