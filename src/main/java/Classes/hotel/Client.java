package Classes.hotel;

import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String numero;
    private int idclient;
    private String email ;
    public Client(String nom, String prenom, String numero, int idclient, String email ){
        this.nom=nom;
        this.prenom=prenom;
        this.numero=numero;
        this.idclient=idclient;
        this.email=email;
    }

    public int getIdclient() {
        return idclient;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
