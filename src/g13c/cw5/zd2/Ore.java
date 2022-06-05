package g13c.cw5.zd2;

public class Ore extends Mineral{

    private boolean metalic;

    public Ore(String name, int baseReagent, int power, boolean metalic){
        super(name, baseReagent, power);
        this.metalic=metalic;
    }

    boolean isMetalic(){
        return metalic;
    }

    @Override
    protected int getReagent() {
        int divide=metalic?1:2;
        return super.getReagent()/divide;
    }
}
