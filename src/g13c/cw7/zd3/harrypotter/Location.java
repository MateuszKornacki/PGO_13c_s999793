package g13c.cw7.zd3.harrypotter;

public enum Location implements ValueLocation{
    England, London, GodricsHollow, Hogwarts;

    @Override
    public Location getLocation() {
        return this;
    }
}
