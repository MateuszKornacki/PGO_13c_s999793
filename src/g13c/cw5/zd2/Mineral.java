package g13c.cw5.zd2;

public class Mineral extends Ingredient{

    private final int power;

    protected Mineral(String name, int baseReagent, int power) {
        super(name, baseReagent);
        this.power=power;
    }

    int getPower(){
        return power;
    }

    @Override
    protected int getReagent() {
        return getBaseReagent()+getPower();
    }
}
