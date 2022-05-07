package g13c.cw3.zd2;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Product extends Base{

    private final String name;
    private final ProductType productType;
    private double price;
    private int quantity;
    private Storage storage = null;

    public Product(String name, ProductType productType, double price, int quantity){
        checkArgIsBlank(name);
        checkArgIsNull(productType);
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(String name, ProductType productType, double price, int quantity, Storage storage){
        this(name, productType, price, quantity);
        checkArgIsNull(storage);
        this.storage = storage;
    }

    public String getName(){
        return name;
    }

    public ProductType getProductType(){
        return productType;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public Optional<Storage> getStorage(){
        return ofNullable(storage);
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }

    public void sell(){
        quantity--;
    }

    public void increaseQuantity(int quantity){
        if(quantity<1)throw new RuntimeException("Wartość jest mniejsza niż jeden");
        this.quantity+=quantity;
    }

    public boolean isAvailable(){
        return quantity > 0;
    }

    public int getDeliveryTime(){
        if(storage == null) return 0;
        return storage.getDeliveryTime();
    }

    @Override
    public String toString(){
        return String.format("Product name: %s, deliveryTime: %s, productType: %s, price: %s, quantity: %s, storage: %s",
                getName(), getDeliveryTime(), getProductType(), getPrice(), getQuantity(), getStorage());
    }
}
