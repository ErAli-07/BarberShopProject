import java.util.Vector;

public class BarberShop {

    private final String BarberShopName;
    private Vector <Client> listOfClients;
    private int maxSizeList;

    BarberShop(String BarberShopName, int maxSizeList) {
        this.BarberShopName = BarberShopName;
        this.maxSizeList = maxSizeList;
        listOfClients = new Vector<>();
    }

    public synchronized void addClient(Client client) {
        if(listOfClients.size() < maxSizeList) {
            listOfClients.add(client);
            System.out.println(client.getName() + " has entered the barber shop.");
            notify();
        }
        else{
            System.out.println("Reached max client list-");
        }
    }

    public synchronized void removeClient() {
        if (!listOfClients.isEmpty()) {
            Client client = listOfClients.get(0);
            listOfClients.remove(0);
            System.out.println(client.getName() + " has left the barber shop.");
        }
    }

    public boolean isShopFree(){
        return listOfClients.size()==0;
    }

    public int getSizeList(){
        return listOfClients.size();
    }

    public Client getFirstClient(){
        return listOfClients.get(0);
    }
}
