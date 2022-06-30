package g13c.cw7.zd3.harrypotter;

abstract class ObjectNameAndLocation implements ValueLocation{
    private final String name;
    private Location location;
    public ObjectNameAndLocation(String name, Location location) {
        this.name=name;
        this.location=location;
    }

    protected String getName(){
        return name;
    }

    @Override
    public Location getLocation(){
        return location;
    }

    protected void moveTo(ValueLocation location){
        this.location=location.getLocation();
    }
}
