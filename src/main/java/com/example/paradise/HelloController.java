package com.example.paradise;

import Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class HelloController {

    private ArrayList<Reservation> reservations ;
    private LinkedList<Chambre> chambres = new LinkedList<Chambre>();
    public void Deck(){

        // Creation de chambre, et seulement de Chambre
        for(int i=0;i<=19;i++){
            chambres.add(new ChambreClassiqueLitSimple(i,1,true,60));
        }
        for(int i=20;i<=40;i++){
            chambres.add(new ChambreClassiqueLitDouble(i,2,true,70));
        }
        for (int i=100;i<=109;i++){
            chambres.add(new ChambreDeLuxeLitSimple(i,3,true,100));
        }
        for(int i=110;i<=120;i++){
            chambres.add(new ChambreDeLuxeLitDouble(i,4,true,110));
        }
    }


    @FXML
    private TextField client_nom, client_prenom, client_numero, client_email, chambre_numero ;
    private DatePicker date_debut, date_fin ;



    @FXML
    private Label result_reservation ;

    @FXML
    private ListView<Object> liste_chambres = new ListView<Object>() ;
    @FXML
    private CheckBox lit_simple, lit_double, chambre_classique, chambre_luxe ;

    @FXML
    protected void makeReservation() {

        if( !client_numero.getText().isEmpty() & !client_nom.getText().isEmpty() & !client_email.getText().isEmpty() & !client_prenom.getText().isEmpty() ){
            result_reservation.setVisible(true);

            for( Chambre c : chambres ){
                if(Integer.toString(c.getId()).equals(chambre_numero.getText())){
                    reservations.add( new Reservation( c, new Client( client_nom.getText(),client_prenom.getText(),client_numero.getText(),client_email.getText() ), "12-12-2003", "12-12-2003" ) ) ;
                }
            }

            result_reservation.setText("Reservation for "+client_nom.getText()+" ["+client_numero.getText()+"] to the room "+chambre_numero.getText()+" have been effectuated !");
        }
        else{
            result_reservation.setVisible(true);
            result_reservation.setText("You need to add values in all the fields !");
        }
    }

    private int whatChecks(){
        if (lit_double.isSelected() & chambre_classique.isSelected() & chambre_luxe.isSelected()) {
            return 1;
        }
        else if (lit_double.isSelected() && chambre_classique.isSelected()) {
            return 2;
        }
        else if (lit_double.isSelected() && chambre_luxe.isSelected()) {
            return 3;
        }
        else if (lit_double.isSelected()) {
            return 4;
        }
        else if (chambre_classique.isSelected() && chambre_luxe.isSelected()) {
            return 5;
        }
        else if (chambre_classique.isSelected()) {
            return 6;
        }
        else if (chambre_luxe.isSelected()) {
            return 7;
        }
        else{
            return 0 ;
        }
    }

    public void rechercherChambre() {

        ObservableList<Object> items = FXCollections.observableArrayList();
        if( chambres.isEmpty() ){
            Deck() ;
        }

        for( Chambre c : chambres ){
            items.add(c) ;
        }

        liste_chambres.setItems(items);
    }
}

