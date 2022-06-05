package g13c.cw5.zd2;

public class Liquid extends Ingredient {

    private final int dissolubility;

    protected Liquid(String name, int baseReagent, int dissolubility){
        super(name, baseReagent);
        checkPercent(dissolubility);
        this.dissolubility=dissolubility;
    }

    int getDissolubility(){
        return dissolubility;
    }

    @Override
    protected int getReagent() {
        return (int)(getBaseReagent()*((float)getDissolubility()/100));
    }
}
