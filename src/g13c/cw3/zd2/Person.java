package g13c.cw3.zd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Person extends Base{

    private final String name;
    private final String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart current;
    private final List<ShoppingCart> history;

    public Person(String name, String surname, double moneyInCash, double moneyOnCard){
        checkArgIsBlank(name);
        checkArgIsBlank(surname);
        this.name = name;
        this.surname = surname;
        this.moneyInCash = moneyInCash;
        this.moneyOnCard = moneyOnCard;
        this.history = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public double getMoneyInCash(){
        return moneyInCash;
    }

    public double getMoneyOnCard(){
        return moneyOnCard;
    }

    public Optional<ShoppingCart> getCurrent(){
        return ofNullable(current);
    }

    public List<ShoppingCart> getHistory(){
        return history.stream().collect(toUnmodifiableList());
    }

    public void makeOrder(){
        if(current != null) throw new RuntimeException("Już istnieje zamówienie");
        current = new ShoppingCart();
    }

    public void buyByCard(){
        if (current == null) throw new RuntimeException("Nie masz aktualnego koszyka");
        if(moneyOnCard < current.getTotalPrice()) throw new RuntimeException("Za mało pieniędzy na karcie");
        moneyOnCard -= current.getTotalPrice();
        buy();
    }

    public void buyInCash(){
        if (current == null) throw new RuntimeException("Nie masz aktualnego koszyka");
        if(moneyInCash < current.getTotalPrice()) throw new RuntimeException("Za mało pieniędzy w gotówce");
        moneyInCash -= current.getTotalPrice();
        buy();
    }

    private void buy(){
        current.sell();
        history.add(current);
        current = null;
    }

    public void addProduct(Product product){
        if(current==null) throw new RuntimeException("Nie masz koszyka");
        current.addProduct(product);
    }

    public void deleteProduct(Product product){
        if(current==null) throw new RuntimeException("Nie masz koszyka");
        current.deleteProduct(product);
    }

    @Override
    public String toString(){
        return String.format("Person name: %s, surname: %s, moneyInCash: %s, moneyOnCard: %s, current: %s, history: %s",
                getName(), getSurname(), getMoneyInCash(), getMoneyOnCard(), getCurrent(), getHistory());
    }
}
