package g13c.cw3.zd2;

public class Storage {

    private final int deliveryTime;

    public Storage(int deliveryTime){
        if(deliveryTime < 1) throw new RuntimeException("Czas dostawy nie może być mniejszy od jeden");
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryTime(){
        return deliveryTime;
    }

    @Override
    public String toString(){
        return String.format("Storage deliveryTime: %s", getDeliveryTime());
    }
}
