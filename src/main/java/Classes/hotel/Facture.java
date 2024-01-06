package Classes.hotel;

import java.io.Serializable;

public class Facture implements Serializable {
    private int id;
    private int compte;

    public Facture(int id, int compte) {
        this.id = id;
        this.compte = compte;
    }

    public int addcompte(int prix){
        compte+=prix;
        return compte;
    }

    public void movcompte(int prix){
        compte-=prix;
    }
    public void delcompte(){
        compte = 0;
    }

    public int getCompte() {
        return compte;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "le client doit payer: "+compte;
    }
}