public class BarberShop {

    private final String BarberShopName;
    private final Barber barber;
    private Client[] clients;

    BarberShop(String BarberShopName, Barber barber) {
        this.BarberShopName = BarberShopName;
        this.barber = barber;
    }
}
