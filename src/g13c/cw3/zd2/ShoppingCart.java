package g13c.cw3.zd2;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class ShoppingCart {

    private static long nextID = 0;

    private final long id;
    private final Set<Product> products;


    public ShoppingCart() {
        id = nextID;
        nextID++;
        products = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public Set<Product> getProducts(){
        return products.stream().collect(toUnmodifiableSet());
    }

    public void sell() {
        for (Product product : products) {
            if(!product.isAvailable()) throw new RuntimeException("Produkt " + product.getName() + " jest niedostępny");
        }
        for (Product product : products) {
            product.sell();
        }
    }

    public int getTotalDeliveryTime() {
        int currentMax = 0;
        for (Product product : products) {
            if (product.getDeliveryTime() > currentMax) currentMax = product.getDeliveryTime();
        }

        return currentMax;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    void addProduct(Product product){
        if(!product.isAvailable()) throw new RuntimeException("Produkt jest niedostęny, " + product);
        products.add(product);
    }

    void deleteProduct(Product product){
        products.remove(product);
    }

    @Override
    public String toString(){
        return String.format("ShoppingCart id: %s, products: %s", getId(), getProducts());
    }
}
