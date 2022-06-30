package g13c.cw7.zd3.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class Voldemort extends Tutor{

    private static final String LORD_VOLDEMORT_NAME = "Lord Voldemort";
    private static final String CREATED_HORCRUXES_TEXT = "Created horcruxes:";
    private static final String HORCRUX_PATTERN = "\thorcrux %s\n";
    private int horcruxes;

    private final List<Character> targetsCharacters;
    private final List<Child> targetsChildren;

    public Voldemort(Riddle riddle){
        super(LORD_VOLDEMORT_NAME, riddle.getLocation());
        horcruxes=0;
        riddle.override();
        targetsCharacters = new ArrayList<>();
        targetsChildren = new ArrayList<>();
    }
    public void createHorcruxes(int value){
        horcruxes+=value;
    }

    public void printHorcruxes(){
        log(CREATED_HORCRUXES_TEXT);
        for(int i=1; i<=horcruxes; i++){
            log(HORCRUX_PATTERN, i);
        }
    }

    public void target(Character character){
        targetsCharacters.add(character);
    }

    public void target(Child child){
        targetsChildren.add(child);
    }

    public void castSpell(Spell spell){
        for(Character character: targetsCharacters){
            if(character.getLocation() == getLocation()) character.targetSpell(spell);
        }
        for(Character character: targetsChildren){
            if(character.getLocation() == getLocation()) character.target(0);
        }
        targetSpell(spell);
    }

}
