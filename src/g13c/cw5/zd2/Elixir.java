package g13c.cw5.zd2;

import java.util.ArrayList;
import java.util.List;

public class Elixir {

    private String name;
    private boolean isCreated;
    private int power;
    private List<Ingredient> ingredients;
    private Liquid catalyst;

    public Elixir(String name){
        this.name=name;
        this.isCreated=false;
        this.power=0;
        this.ingredients=new ArrayList<>();
    }

    public void create(){
        isCreated=true;
        int sumReagent=0;
        for(Ingredient ingredient:ingredients){
            sumReagent+=ingredient.getReagent();
        }

        power=sumReagent/catalyst.getReagent();

    }

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;
    }

    public boolean isCreated(){
        return isCreated;
    }


    public void addIngredient(Ingredient newIngredient){
       if(isCreated) throw new RuntimeException("Nie można dodać, eliksir został już utworzony");
        ingredients.add(newIngredient);
    }

    public void removeIngredient(Ingredient ingredient){
        if(isCreated) throw new RuntimeException("Nie można usunąć, eliksir został już utworzony");
        ingredients.remove(ingredient);
    }

    public void setCatalyst(Liquid catalyst){
        if(isCreated) throw new RuntimeException("Nie można zmienić, eliksir został już utworzony");
        this.catalyst=catalyst;
    }

    @Override
    public String toString(){
        return String.format("name: %s, Power: %s, isCreated: %s", getName(), getPower(), isCreated());
    }

}
