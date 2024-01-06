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

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HelloController implements Serializable {

    public static final Paradise paradise = Serialisation.getObject() ;
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

        if( !client_numero.getText().isEmpty() & !client_nom.getText().isEmpty() & !client_email.getText().isEmpty() & !client_prenom.getText().isEmpty() ){
            result_reservation.setVisible(true);

            for( Chambre c : chambres ){
                if( Objects.equals(c.getNbChambre(), chambre_numero.getText()) ){
                    System.out.println(chambre_numero.getText());
                }
            }
            IDCLIENT++ ;
            result_reservation.setText("Reservation for "+client_nom.getText()+" ["+client_numero.getText()+"] to the room "+chambre_numero.getText()+" have been effectuated !");
        }
        else{
            result_reservation.setVisible(true);
            result_reservation.setText("You need to add values in all the fields !");
        }
        Serialisation.putObject(paradise);

        for( Reservation r : reservations ){
            System.out.println(r.toString());
        }

    }

    @FXML
    public void rechercherChambre() {
        ObservableList<Object> items = FXCollections.observableArrayList();

        if( Classiquedouble.isSelected() ) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "2")){
                    items.add(c) ;
                }
            }
        }
        if (Classiquesimple.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "1")){
                    items.add(c) ;
                }
            }
        }
        if (Luxesimple.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "3")){
                    items.add(c) ;
                }
            }
        }
        if (Luxedouble.isSelected()) {
            for( Chambre c : chambres ){
                if(Objects.equals(c.getId(), "4")){
                    items.add(c) ;
                }
            }
        }

        liste_chambres.setItems(items);
        Serialisation.putObject(paradise);
    }

    @FXML
    private void afficherListeReservations(){

        ObservableList<Object> items = FXCollections.observableArrayList();
        for( Reservation r : reservations ){
            items.add(r) ;
        }

        for( Chambre c : chambres ){
            if(Objects.equals(c.getNbChambre(), chambre_numero.getText())){
                System.out.println("XXXXXXXXXXXX");
            }
            System.out.println("YY "+c.getId());
        }

        System.out.println(chambre_numero.getText());

        liste_reservations.setItems(items);
        Serialisation.putObject(paradise);

    }

}

