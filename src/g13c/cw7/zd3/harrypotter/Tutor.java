package g13c.cw7.zd3.harrypotter;

abstract class Tutor extends Character{

    protected Tutor(String name, Location location) {
        super(name, location);
    }

    @Override
    public void moveTo(ValueLocation location){
        super.moveTo(location);
    }
}
