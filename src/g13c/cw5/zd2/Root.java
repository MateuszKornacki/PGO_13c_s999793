package g13c.cw5.zd2;

public class Root extends Plants{

    public Root(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    protected int getReagent() {
        return super.getReagent()/2;
    }
}
