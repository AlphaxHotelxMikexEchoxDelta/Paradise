package com.example.paradise;

import Classes.chambres.*;
import Classes.hotel.Paradise;
import Classes.hotel.Reservation;
import Classes.sauvegarde.Serialisation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class HelloApplication extends Application implements Serializable {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 520);
        stage.setTitle("Paradise Hotel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        ArrayList<Chambre> chambres = new ArrayList<Chambre>();

        for(int i=0;i<=19;i++){
            String o = String.valueOf(i) ;
            chambres.add(new ClassiqueLitSimple(o,"1",true,60));
        }
        for(int i=20;i<=40;i++){
            String o = String.valueOf(i) ;
            chambres.add(new ClassiqueLitSimple(o,"2",true,70));
        }
        for (int i=100;i<=109;i++){
            String o = String.valueOf(i) ;
            chambres.add(new ClassiqueLitSimple(o,"3",true,100));
        }
        for(int i=110;i<=120;i++){
            String o = String.valueOf(i) ;
            chambres.add(new ClassiqueLitSimple(o,"4",true,110));
        }
        ArrayList<Reservation> reservations = new ArrayList<Reservation>() ;


        Serialisation.putObject(

                new Paradise(
                        "TheParadise", 4, chambres.size(),
                        chambres, reservations, 0
                )

        );

        launch();
        Serialisation.putObject(HelloController.paradise);
    }
}