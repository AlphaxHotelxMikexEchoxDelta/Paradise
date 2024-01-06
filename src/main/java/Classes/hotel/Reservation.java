package Classes.hotel;
import Classes.chambres.Chambre;

import java.io.Serializable;

public class Reservation implements Serializable {
    private String IDChambre;
    private Client client;
    private String debureservation;
    private String finreservation;

    public Reservation (String IDChambre,Client client,String debureservation,String finreservation){
        this.IDChambre=IDChambre;
        this.client=client;
        this.debureservation=debureservation;
        this.finreservation=finreservation;
    }

    public String getChambre() {
        return IDChambre;
    }

    public void setChambre(String chambre) {
        this.IDChambre = chambre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDebureservation() {
        return debureservation;
    }

    public void setDebureservation(String debureservation) {
        this.debureservation = debureservation;
    }

    public String getFinreservation() {
        return finreservation;
    }

    public void setFinreservation(String finreservation) {
        this.finreservation = finreservation;
    }

    @Override
    public String toString() {
        return "Reservation{ chambre " + IDChambre + ", client=" + client.getIdclient() +", debureservation=" + debureservation + ", finreservation=" + finreservation +" }";
    }

/*
    public static Date choixdujour(Scanner scan, Calendar calendar){
        System.out.print("Year: ");
        int year = scan.nextInt();
        System.out.print("Mounth: ");
        int month = scan.nextInt();
        System.out.print("Day: ");
        int day = scan.nextInt();
        System.out.print("Hour: ");
        int hour = scan.nextInt();
        System.out.print("Minute: ");
        int minute =scan.nextInt();



        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Mois commence à 0
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        return calendar.getTime();

    }
    public static int NbDeJour(Scanner scan){
        int jours = scan.nextInt();
        return jours;
    }
    public static Date finDeReservation(Date date,int jours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, jours);
        return calendar.getTime();
    }
    //il faut les mettre dans le main pour que les methodes fonctionnes 
    Calendar calendar= Calendar.getInstance();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMMM y à H:mm");
    Scanner scan = new Scanner(System.in);*/
}
