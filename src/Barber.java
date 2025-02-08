import java.util.Vector;

public class Barber extends Person {

    private final String name;
    private BarberShop barberShop;

    Barber(String name){
        this.name = name;
    }

    public void setBarberShop(BarberShop barberShop){
        this.barberShop = barberShop;
    }

    public void entrance(){
        System.out.println(this.name + " the barber is ready to begin");
    }

    public void isWorking(){
        System.out.println(this.name + " the barber is working");
    }

    public void isNotWorking(){
        System.out.println(this.name + " the barber is resting");
    }

    public void isCutting(Client thisClient){
        System.out.println(this.name + " the barber is cutting...");
        try{
            Thread.sleep(4500);
        }catch(InterruptedException excp){
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " finished cutting " + thisClient.getName() + "'s hair.");
    }

    @Override
    public void run() {
        while(true){
            Client thisClient = null;

            synchronized(barberShop){
                if (barberShop.isShopFree()) {
                    isNotWorking();
                    try {
                        barberShop.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                entrance();
                thisClient = barberShop.getFirstClient();
            }
            isWorking();
            isCutting(thisClient);
            synchronized(barberShop){
                barberShop.removeClient();
            }
        }
    }
}
