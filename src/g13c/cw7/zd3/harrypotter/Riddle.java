package g13c.cw7.zd3.harrypotter;

public class Riddle extends Child{

    private boolean override;
    public Riddle(String name, Location location) {
        super(name, location);
        override=false;
    }

    private boolean isOverride(){
        return override;
    }

    void override(){
        override=true;
    }

    @Override
    void printStatus(){
        if(!isOverride())super.printStatus();
    }
}
