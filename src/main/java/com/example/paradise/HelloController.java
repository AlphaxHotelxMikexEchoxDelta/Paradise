package com.example.paradise;

import Classes.chambres.Chambre;
import Classes.hotel.Client;
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
import java.util.Objects;

public class HelloController implements Serializable {

    public static Paradise paradise = Serialisation.getObject() ;
    private int IDCLIENT = paradise.getIDCLIENT() ;
    private ArrayList<Reservation> reservations = paradise.getReservations() ;
    private ArrayList<Chambre> chambres = paradise.getChambres() ;

    @FXML private TextField client_nom, client_prenom, client_numero, client_email, chambre_numero, date_debut, date_fin ;
    @FXML private Label result_reservation ;
    @FXML private ListView<Object> liste_chambres = new ListView<Object>() ;
    @FXML private CheckBox Classiquedouble, Classiquesimple, Luxedouble, Luxesimple ;
    @FXML private ListView<Object> liste_reservations = new ListView<Object>() ;

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

        ObservableList<Object> items = FXCollections.observableArrayList();
        for( Reservation r : reservations ){
            items.add(r) ;
        }

        liste_reservations.setItems(items);
        Serialisation.putObject(paradise);
        paradise = Serialisation.getObject();


    }

}

