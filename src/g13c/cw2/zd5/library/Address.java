package g13c.cw2.zd5.library;

import java.util.Optional;

public class Address {

    private final String country;
    private final String city;
    private final String street;
    private final int house;
    private final Integer flat;

    public Address(String country, String city, String street, int house, Integer flat){
        ArgumentValidator.checkArgIsBlank(country);
        ArgumentValidator.checkArgIsBlank(city);
        ArgumentValidator.checkArgIsBlank(street);
        this.country=country;
        this.city=city;
        this.street=street;
        this.house=house;
        this.flat=flat;
    }

    public Address(String country, String city, String street, int house){
        this(country, city, street, house, null);
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }

    public String getStreet(){
        return street;
    }

    public int getHouse(){
        return house;
    }

    public Optional<Integer> getFlat(){
        return Optional.ofNullable(flat);
    }

    @Override
    public String toString(){
        return String.format("Adres %s %s %s %s %s", getCountry(), getCity(), getStreet(), getHouse(), getFlat());
    }
}
