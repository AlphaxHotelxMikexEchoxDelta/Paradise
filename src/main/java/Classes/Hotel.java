import java.util.ArrayList;

public class Hotel{

    protected String nom ;
    protected int nbEtoile, nbClient, nbChambre ;
    protected ArrayList<Chambre> chambres ;

    public Hotel(String nom,int nbEtoile,int nbClient,int nbChambre,ArrayList<Chambre> chambres) {
        this.nom = nom;
        this.nbEtoile = nbEtoile;
        this.nbClient = nbClient;
        this.nbChambre = nbChambre;
        this.chambres = chambres;

    }

    public int getNbChambre() {
        return nbChambre;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public int getNbClient() {
        return nbClient;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public void setNbChambre(int nbChambre) {
        this.nbChambre = nbChambre;
    }

    public void setNbClient(int nbClient) {
        this.nbClient = nbClient;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }
}
