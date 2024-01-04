package Classes;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel{

  private String nom ;
  private int nbEtoile, nbClient, nbChambre ;
  private ArrayList<Chambre> chambres ;

  public Hotel(String nom, int nbEtoile, int nbClient, int nbChambre, ArrayList<Chambre> chambres) {
    this.nom = nom;
    this.nbEtoile = nbEtoile;
    this.nbClient = nbClient;
    this.nbChambre = nbChambre;
    this.chambres = chambres;
  }



}
