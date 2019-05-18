package Esercizio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        ParkingArea parkingArea = new ParkingArea(20);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Scanner input = new Scanner(System.in);
        Date date = null;
        boolean typeOfVeicle;
        String empty;
        String plate;
        int choice;
        do {
            System.out.println("         Menu          ");
            System.out.println("1-Inserisci un veicolo ");
            System.out.println("2-Rimuovi un veicolo ");
            System.out.println("3-Cerca veicolo");
            System.out.println("4-Stampa parcheggio");
            System.out.println("0-Esci");
            choice = input.nextInt();
            switch(choice) {
                case 1:
                     try {
                         System.out.println("Inserisci il tipo di veicolo:\n1-Automobile\n2-Autotreno");
                         choice = input.nextInt();
                         if(choice==1)
                             typeOfVeicle=true;
                         else
                             typeOfVeicle= false;
                         System.out.println("Inserisci targa del veicolo");
                         plate = input.next();
                         System.out.println("Inserisci data di entrata nel parcheggio(yyyy/MM/dd HH:mm:ss)");
                         empty= input.nextLine();
                         date = fmt.parse(input.nextLine());
                         Vehicle vehicle = new Vehicle(date, typeOfVeicle, plate);
                         parkingArea.addVehicle(vehicle);
                     } catch (Exception e) {
                         System.out.println(e);
                     }
                     break;

                case 2:
                    try {
                        System.out.println("Inserisci targa del veicolo");
                        plate = input.next();
                        System.out.println("Inserisci data di uscita nel parcheggio(yyyy/MM/dd HH:mm:ss)");
                        empty= input.nextLine();
                        date = fmt.parse(input.nextLine());
                        System.out.println("Veicolo rimosso:\n"+parkingArea.removeVehicle(plate, date));
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("Inserisci targa del veicolo");
                    plate = input.next();
                    if(parkingArea.findVihicle(plate) == null)
                        System.out.println("Veicolo non trovato");
                    else
                        System.out.println(parkingArea.findVihicle(plate));
                    break;

                case 4:
                    System.out.println(parkingArea);
                    break;

                case 0: break;
            }
        }while(choice != 0);
    }
}
