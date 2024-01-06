package com.example.paradise;

import Classes.chambres.Chambre;
import Classes.hotel.Client;
import Classes.hotel.Facture;
import Classes.hotel.Paradise;
import Classes.hotel.Reservation;
import Classes.sauvegarde.Serialisation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.net.ssl.SSLContext;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class HelloController implements Serializable {

    public static Paradise paradise = Serialisation.getObject() ;
    private int IDCLIENT = paradise.getIDCLIENT() ;
    private ArrayList<Reservation> reservations = paradise.getReservations() ;
    private ArrayList<Chambre> chambres = paradise.getChambres() ;

    @FXML private TextField client_nom, client_prenom, client_numero, client_email, chambre_numero, date_debut, date_fin ;
    @FXML private TextField chambre_numero1, date_debut1, date_fin1, RRR1, chambre_numero2 ;
    @FXML private Label result_reservation, resulta_extras, resulta_extras2, resulta_extras3 ;
    @FXML private ListView<Object> liste_chambres = new ListView<Object>() ;
    @FXML private ArrayList<Facture> factures = new ArrayList<Facture>();
    @FXML private CheckBox Classiquedouble, Classiquesimple, Luxedouble, Luxesimple ;
    @FXML private ListView<Object> liste_reservations = new ListView<Object>() ;
    @FXML private TextField RRR, MMM, RRR2 ;


    @FXML
    private void modReservation(){

        int uu = Integer.parseInt(RRR1.getText());
        int pp = Integer.parseInt(chambre_numero1.getText());
        int yy = Integer.parseInt(chambre_numero2.getText());

        if( yy > 0 || yy < reservations.size() || pp > 0 || pp < chambres.size() || uu > 0 || uu < reservations.size() ){

            chambres.get(yy).setStatus(false);
            chambres.get(pp).setStatus(true);



            reservations.get(uu).mod( chambre_numero1.getText(), date_debut1.getText(), date_fin1.getText() );
            resulta_extras2.setText("!!! RESERVATIONS MODIFIER !!! ");

        }
        else{
            resulta_extras.setText("!!! RESERVATIONS INEXISTANTS !!! ");
        }

        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();

    }


    @FXML
    protected void makeReservation() {

        if( !client_numero.getText().isEmpty() & !client_nom.getText().isEmpty() & !client_email.getText().isEmpty() & !client_prenom.getText().isEmpty() ) {
            result_reservation.setVisible(true);

            Integer oo = Integer.parseInt(chambre_numero.getText());

            if( oo > 0 || oo < 61 ){
                if(Objects.equals(chambres.get(oo).statut(), "Occuper")){
                    result_reservation.setText(" !!! CHAMBRE DEJA RESERVER !!! ");
                }
                else {
                    reservations.add(new Reservation(
                            chambres.get(oo).getNbChambre(),
                            new Client(client_nom.getText(), client_prenom.getText(), client_numero.getText(), IDCLIENT, client_email.getText()),
                            date_debut.getText(), date_fin.getText()
                    ));

                    chambres.get(oo).setStatus(true);

                    result_reservation.setText("Reservation for " + client_nom.getText() + " [" + IDCLIENT + "] to the room " + chambre_numero.getText() + " have been effectuated !");
                    factures.add( new Facture( IDCLIENT, chambres.get(oo).getPrix() ) ) ;
                    IDCLIENT++;
                }
            }
            else{
                result_reservation.setText("!!! CHAMBRES INEXISTANT !!!");
            }

        }
        else{
            result_reservation.setText("You need to add values in all the fields !");
        }
        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();
    }


    @FXML
    public void removeReservation(){

        int uu = Integer.parseInt(RRR.getText());
        int pp = Integer.parseInt(MMM.getText());

        if( uu > 0 || uu < reservations.size() && pp > 0 || pp < chambres.size() ){

            int hh = Integer.parseInt(reservations.get(uu).getChambre()) ;

            for( Facture f : factures ){
                if( f.getId() == hh ){
                    f.delcompte();
                }
            }

            chambres.get(pp).setStatus(false);
            reservations.remove(uu) ;
            resulta_extras.setText("!!! RESERVATIONS EFFACER !!! ");



        }
        else{
            resulta_extras.setText("!!! RESERVATIONS INEXISTANTS !!! ");
        }

        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();

    }


    @FXML
    public void rechercherChambre() {
        ObservableList<Object> items = FXCollections.observableArrayList();

        if( Classiquedouble.isSelected() ) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "2")){
                    items.add(c+"\tIDENTIFIANT POUR RESERVATION -> "+ chambres.indexOf(c) +"<-") ;
                }
            }
        }
        if (Classiquesimple.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "1")){
                    items.add(c+"\tIDENTIFIANT POUR RESERVATION -> "+ chambres.indexOf(c) +"<-") ;
                }
            }
        }
        if (Luxesimple.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "3")){
                    items.add(c+"\tIDENTIFIANT POUR RESERVATION -> "+ chambres.indexOf(c) +"<-") ;
                }
            }
        }
        if (Luxedouble.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "4")){
                    items.add(c+"\tIDENTIFIANT POUR RESERVATION -> "+ chambres.indexOf(c) +"<-") ;
                }
            }
        }

        liste_chambres.setItems(items);
        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();

    }

    @FXML
    private void afficherListeReservations(){

        liste_reservations.getItems().clear();

        ObservableList<Object> items = FXCollections.observableArrayList();
        for( Reservation r : reservations ){
            items.add("["+reservations.indexOf(r)+"] "+r) ;
        }

        liste_reservations.setItems(items);
        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();


    }

    @FXML
    private void afficherFacture(){

        int prix = 0 ;
        int pupu = Integer.parseInt(RRR2.getText()) ;

        for( Facture f : factures ){
            System.out.println(f.getCompte()+" "+f.getId());
            if( f.getId() == pupu ){

                prix+=f.getCompte() ;

            }
        }

        if(factures.getLast() != null){
            factures.remove( factures.getLast() ) ;
        }

        resulta_extras3.setText( " [id reservation "+pupu+"] total a payer est de: "+prix+"€" );

        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();


    }


}

