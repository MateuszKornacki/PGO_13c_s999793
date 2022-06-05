package g13c.cw5.zd2;

public class Flower extends Plants{

    public Flower(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    protected int getReagent() {
        return super.getReagent()*2;
    }
}
