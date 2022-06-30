package g13c.cw7.zd3.harrypotter;

public class Orphanage extends ObjectNameAndLocation{
    public Orphanage(String name, Location location) {
        super(name, location);
    }

    public void addChild(Child child){
        child.moveTo(getLocation());
    }

}
