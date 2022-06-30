package g13c.cw7.zd3.harrypotter;

public enum Spell {
    AvadaKedavra(100);

    private final int power;

    Spell(int power){
        this.power = power;
    }

    public int getPower(){
        return power;
    }
}
