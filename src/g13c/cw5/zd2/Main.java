package g13c.cw5.zd2;

public class Main {

    public static void main(String[] args){

        Elixir shakeCzekoladowy= new Elixir("Shake czekoladowy");
        Water woda=new Water("Woda",30,26, false);
        Alcohol alkohol=new Alcohol("Alkohol", 3, 7, 90);
        Ore ore=new Ore("Ore", 7, 3, true);
        Crystal crystal=new Crystal("Crystal",3, 8, 10);
        Flower flower=new Flower("Flower", 3, 9);
        Root root = new Root("Root", 3, 3);

        shakeCzekoladowy.addIngredient(woda);
        shakeCzekoladowy.addIngredient(alkohol);
        shakeCzekoladowy.addIngredient(ore);
        shakeCzekoladowy.addIngredient(crystal);
        shakeCzekoladowy.addIngredient(flower);
        shakeCzekoladowy.addIngredient(root);

        shakeCzekoladowy.setCatalyst(woda);

        shakeCzekoladowy.create();
        System.out.print(shakeCzekoladowy);
    }
}
