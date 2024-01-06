package com.example.paradise;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class HelloController {

    private int IDCLIENT = 0 ;
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>() ;
    private LinkedList<Chambre> chambres = new LinkedList<Chambre>();
    public void Deck(){

        // Creation de chambre, et seulement de Chambre
        for(int i=0;i<=19;i++){
            chambres.add(new ClassiqueLitSimple(i,1,true,60));
        }
        for(int i=20;i<=40;i++){
            chambres.add(new ClassiqueLitDouble(i,2,true,70));
        }
        for (int i=100;i<=109;i++){
            chambres.add(new LuxeLitSimple(i,3,true,100));
        }
        for(int i=110;i<=120;i++){
            chambres.add(new LuxeLitDouble(i,4,true,110));
        }
    }


    @FXML private TextField client_nom, client_prenom, client_numero, client_email, chambre_numero ;
    @FXML private DatePicker date_debut = null ;
    @FXML private DatePicker date_fin = null ;
    @FXML private Label result_reservation ;
    @FXML private ListView<Object> liste_chambres = new ListView<Object>() ;
    @FXML private CheckBox Classiquedouble, Classiquesimple, Luxedouble, Luxesimple ;
    @FXML private ListView<Object> liste_reservations = new ListView<Object>() ;

    @FXML
    protected void makeReservation() {

        if( !client_numero.getText().isEmpty() & !client_nom.getText().isEmpty() & !client_email.getText().isEmpty() & !client_prenom.getText().isEmpty() ){
            result_reservation.setVisible(true);

            LocalDate dateDEBUT = date_debut.getValue();
            LocalDate dateFIN = date_fin.getValue();

            for( Chambre c : chambres ){
                if(Integer.toString(c.getId()) == chambre_numero.getText() ){
                    reservations.add( new Reservation( c, new Client( client_nom.getText(),client_prenom.getText(),client_numero.getText(), IDCLIENT,client_email.getText() ), dateDEBUT.toString(), dateFIN.toString() ) ) ;
                }
            }
            IDCLIENT++ ;
            result_reservation.setText("Reservation for "+client_nom.getText()+" ["+client_numero.getText()+"] to the room "+chambre_numero.getText()+" have been effectuated !");
        }
        else{
            result_reservation.setVisible(true);
            result_reservation.setText("You need to add values in all the fields !");
        }
    }

    @FXML
    public void rechercherChambre() {
        ObservableList<Object> items = FXCollections.observableArrayList();

        if( chambres.isEmpty() ){
            Deck();
        }

        if( Classiquedouble.isSelected() ) {
            for( Chambre c : chambres ){
                if( c.getId() == 2 ){
                    items.add(c) ;
                }
            }
        }
        if (Classiquesimple.isSelected()) {
            for( Chambre c : chambres ){
                if( c.getId() == 1 ){
                    items.add(c) ;
                }
            }
        }
        if (Luxesimple.isSelected()) {
            for( Chambre c : chambres ){
                if( c.getId() == 3 ){
                    items.add(c) ;
                }
            }
        }
        if (Luxedouble.isSelected()) {
            for( Chambre c : chambres ){
                if( c.getId() == 4 ){
                    items.add(c) ;
                }
            }
        }

        liste_chambres.setItems(items);
    }

    @FXML
    private void afficherListeReservations(){

        reservations.add(new Reservation(
                new ClassiqueLitSimple(1,9999,true,60),
                new Client(
                        "BOB",
                        "BOB",
                        "09987",
                        1,
                        "JYFJYF"
                ),
                "12-12-2003",
                "12-12-2003"
        ) ) ;

        ObservableList<Object> items = FXCollections.observableArrayList();
        for( Reservation r : reservations ){
            items.add(r) ;
        }

        liste_reservations.setItems(items);

    }

}

