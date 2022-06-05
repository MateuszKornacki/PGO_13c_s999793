package g13c.cw5.zd2;

public class Alcohol extends Liquid{

    private int percentage;

    public Alcohol(String name, int baseReagent, int dissolubility, int percentage){
        super(name, baseReagent, dissolubility);
        checkPercent(percentage);
        this.percentage=percentage;
    }

    int getPercentage(){
        return percentage;
    }

    @Override
    protected int getReagent(){
        return super.getReagent()*(getPercentage()/100);
    }
}
