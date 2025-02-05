public class Client extends Person {

    private final String name;

    private static int counter = 1;

    Client(String name){
        this.name = name;
    }

    protected synchronized Client generate(){
        boolean flag = true;
        while(flag){
            Client c = new Client("T"+counter);
            counter++;
            return c;
        }
        return null;
    }
}
