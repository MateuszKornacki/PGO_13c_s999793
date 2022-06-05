package g13c.cw5.zd2;

public class Water extends Liquid{

    private boolean distilated;

    public Water(String name, int baseReagent, int dissolubility, boolean distilated){
        super(name, baseReagent, dissolubility);
        this.distilated=distilated;
    }

    boolean isDistilated(){
        return distilated;
    }

    @Override
    protected int getReagent(){
        int divide=distilated?1:2;
        return super.getReagent()/divide;
    }
}
