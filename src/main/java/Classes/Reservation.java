package Classes;

import java.util.Date;
public class Reservation {
    private Chambre chambre;
    private Client client;
    private String debureservation;
    private String finreservation;
    public Reservation(Chambre chambre,Client client,String debureservation,String finreservation){
        this.chambre=chambre;
        this.client=client;
        this.debureservation=debureservation;
        this.finreservation=finreservation;
    }


}
