import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class reservation {
    private Chambre chambre;
    private Client client;
    //private Date debureservation;
    private Date finreservation;
    public reservation (Chambre chambre,Client client,Date debureservation,Date finreservation){
        this.chambre=chambre;
        this.client=client;
        //this.debureservation=debureservation;
        this.finreservation=finreservation;
    }

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
    /*Calendar calendar= Calendar.getInstance();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMMM y à H:mm");
    Scanner scan = new Scanner(System.in);*/
}
