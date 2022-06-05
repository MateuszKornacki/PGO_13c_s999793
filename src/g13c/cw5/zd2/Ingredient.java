package g13c.cw5.zd2;

abstract class Ingredient {

    private final String name;
    private final int baseReagent;

    protected Ingredient(String name, int baseReagent){
        this.name = name;
        this.baseReagent=baseReagent;
    }

    String getName(){
        return name;
    }

    protected int getBaseReagent(){
        return baseReagent;
    }

    protected abstract int getReagent();

    protected void checkPercent(int value){
        if(value<0||value>100) throw new IllegalArgumentException("Wartość musi być od 0 do 100");
    }

    protected void checkIsMinus(int value){
        if (value<0) throw new IllegalArgumentException("Wartość musi być większa od 0");
    }

}
