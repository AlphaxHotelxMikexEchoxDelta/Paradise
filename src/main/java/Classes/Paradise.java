package Classes;
import java.util.ArrayList;
import java.util.HashMap;

public class Paradise extends Hotel /*implements MethodsHotel*/ {

    private HashMap<Chambre,Client> reservations ;

    public Paradise(String nom, int nbEtoile, int nbClient, int nbChambre, ArrayList<Chambre> chambres) {
        super(nom, nbEtoile, nbClient, nbChambre, chambres);
    }

    public String makeReservation( Chambre chambre, Client client ){
        this.reservations.put( chambre, client );
        return "Reservation effectuer" ;
    }
    public String adandonReservation(Chambre chambre,Client client){
        //
        return "Réservation annuler";
    }
    public String modificationReservation(Chambre chambre,Client client){
        //
        return "Réservation modifier";
    }
    public String supprimerReservation(Chambre chambre, Client client){
        //
        return "Réservation supprimer";
    }
    public String commanderUnRepas(Repas repas){
        //
        return "Repas commander";
    }

    public HashMap<Chambre, Client> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Chambre, Client> reservations) {
        this.reservations = reservations;
    }

}
