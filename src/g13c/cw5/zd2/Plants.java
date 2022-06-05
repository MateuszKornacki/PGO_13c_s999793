package g13c.cw5.zd2;

public class Plants extends Ingredient{

    private final int toxity;

    public Plants(String name, int baseReagent, int toxity){
        super(name, baseReagent);
        checkIsMinus(toxity);
        this.toxity=toxity;
    }

    int getToxity(){
        return toxity;
    }

    @Override
    protected int getReagent() {
        return super.getBaseReagent()*(getToxity()/100);
    }
}
