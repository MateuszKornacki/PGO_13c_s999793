package g13c.cw3.zd2;

public class Main {

    public static void main(String[] args){

        Storage warszawa = new Storage (5);
        Storage gdansk = new Storage (20);

        Product banan = new Product("banan", ProductType.CONSUMABLE, 10000, 2);
        Product monitor = new Product( "monitor", ProductType.ELECTRONIC, 3999.9, 100, warszawa);
        Product klawiatura = new Product( "klawiatura", ProductType.ELECTRONIC, 200, 3, warszawa);
        Product graPlanszowa = new Product( "gra planszowa", ProductType.ENTERTAINMENT, 160.6, 78, gdansk);

        Person klient = new Person("Jan", "Kowalski", 90000, 12000);
        Person klient2 = new Person("Anna", "Nowak", 9000, 120);

        System.out.println(klient);

        klient.makeOrder();
        klient.addProduct(klawiatura);
        klient.addProduct(banan);

        System.out.println(klient);

        klient.buyByCard();

        System.out.println(klient);

        //Próba zakupu na pustym koszyku
        try {
            System.out.print("TEST1: ");
            klient.buyByCard();
        }catch (RuntimeException e){
            System.out.println(e);
        }

        klient.makeOrder();
        klient.addProduct(klawiatura);
        klient.addProduct(banan);
        klient.addProduct(monitor);
        klient.addProduct(graPlanszowa);
        //Brak środków na karcie
        try{
            System.out.print("TEST2: ");
            klient.buyByCard();
        }catch (RuntimeException e){
            System.out.println(e);
            klient.buyInCash();
            System.out.println(klient);
        }

        //Niedostępny produkt banan
        klient.makeOrder();
        try {
            System.out.print("TEST3: ");
            klient.addProduct(banan);
        }catch (RuntimeException e){
            System.out.println(e);
        }

        //Dodana klawiatura do dwóch klientów z dostępnością jeden, klient2 kupuje, przy próbie zakupu przez klienta1 błąd
        klient.addProduct(klawiatura);
        System.out.println(klient);

        klient2.makeOrder();
        klient2.addProduct(klawiatura);
        System.out.println(klient);

        klient2.buyInCash();
        try{
            System.out.print("TEST4: ");
            klient.buyInCash();
        }catch (RuntimeException e){
            System.out.println(e);
        }
    }
}
