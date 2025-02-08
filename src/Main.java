import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner my_scan = new Scanner(System.in);

        //Insertion of the data
        System.out.println("Insert the name of the barberShop: ");
        String name = my_scan.nextLine();

        System.out.println("Max size of the barberShop: ");
        int maxSize = my_scan.nextInt();
        my_scan.nextLine();

        System.out.println("Name of the barber: ");
        String barberName = my_scan.nextLine();

        Barber barber1 = new Barber(barberName);
        BarberShop barberShop = new BarberShop(name, maxSize);
        barber1.setBarberShop(barberShop);

        Thread barberThread = new Thread(barber1);
        barberThread.start();

        //Barber Shop Management
        int i = 1;
        while(true){
            Client new_client = new Client("T"+i);
            barberShop.addClient(new_client);
            i++;

            synchronized (barberShop) {
                barberShop.notify();
            }

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

            if(i==10){
                break;
            }
        }
        my_scan.close();
    }
}