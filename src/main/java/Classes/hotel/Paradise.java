package Classes.hotel;
import Classes.chambres.Chambre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Paradise extends Hotel implements MethodsHotel, Serializable {

    private ArrayList<Reservation> reservations ;
    private ArrayList<Chambre> chambres ;
    private int IDCLIENT = 0 ;

    private ArrayList<Facture> factures ;

    public Paradise(String nom, int nbEtoile, int nbChambre, ArrayList<Chambre> chambres, ArrayList<Reservation> reservations, int IDCLIENT, ArrayList<Facture> factures) {
        super(nom, nbEtoile, nbChambre, chambres);
        this.reservations = reservations;
        this.chambres = chambres;
        this.factures = factures ;
        if( IDCLIENT != 0 ){
            this.IDCLIENT = IDCLIENT ;
        }
    }

    public ArrayList<Facture> getFactures() {
        return factures;
    }

    public int getIDCLIENT() {
        return IDCLIENT;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void makeReservations(Reservation reservation) {
        this.reservations.add( reservation );
    }


    private ArrayList<Client> getClients(){
        return null;
    }

    private ArrayList<Chambre> getChambreNoOccupe(){
        ArrayList<Chambre> cc = new ArrayList<Chambre>() ;
        for( Chambre c : chambres ){
            if( c.statut().equals("Libre") ){
                cc.add(c) ;
            }
        }
        return cc ;
    }

    public  ArrayList<Chambre> getChambres(){
        return chambres ;
    }


}

