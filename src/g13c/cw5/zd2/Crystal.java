package g13c.cw5.zd2;

public class Crystal extends Mineral{

    private int magicPower;

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);
        checkIsMinus(magicPower);
        this.magicPower = magicPower;
    }

    int getMagicPower(){
        return magicPower;
    }

    @Override
    protected int getReagent() {
        return super.getReagent()+getMagicPower();
    }
}
