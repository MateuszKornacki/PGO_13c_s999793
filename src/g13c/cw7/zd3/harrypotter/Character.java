package g13c.cw7.zd3.harrypotter;

import java.util.HashSet;
import java.util.Set;

public abstract class Character extends ObjectNameAndLocation{

    private static final Set<Character> characterList = new HashSet<>();
    private static final String STATUS_TEXT_START = "====Status====";
    private static final String STATUS_END = "==============";
    private static final String HELLO_I_AM_PATTERN = "Hello, I am %s\n";
    private static final String SAY_TO_PATTERN = "%s to %s\n\t%s\n";
    private static final String DO_STH_PATTENR = "I am %s, I am %s\n";
    private static final String PRINT_CHARACTER_STATUS_PATTENR = "%s : %s\n";
    private static final String TARGET_SPELL_PATTERN = "%s %s\n";
    private static final String TEXT_AFTER_DIED = "died.";
    private static final String TEXT_STILL_ALIFE = "goes LOL...";

    public static void status(){
        log(STATUS_TEXT_START);
        for(Character character : characterList){
            character.printStatus();
        }
        log(STATUS_END);
    }

    public static void MoveAllTo(Location location, Character ... characters){
        for(Character character: characters){
            character.moveTo(location);
        }
    }

    public static void doSth(String value, Character ... characters) {
        for (Character character : characters) {
            character.doSth(value);
        }
    }

    protected static void log(String pattern, Object ... values){
        System.out.printf(pattern, values);
    }

    protected static void log(String value){
        System.out.println(value);
    }
    private static String getTextAfterDied(){
        return TEXT_AFTER_DIED;
    }

    private static String getTextStillAlife(){
        return TEXT_STILL_ALIFE;
    }


    private int life;

    protected Character(String name, Location location){
        super(name, location);
        life = 100;
        characterList.add(this);
    }

    public void introduce(){
        log(HELLO_I_AM_PATTERN, getName());
    }

    public void say(String value, Character character){
        log(SAY_TO_PATTERN,getName(), character.getName(), value);
    }

    public void doSth(String value){
        log(DO_STH_PATTENR, getName(), value);
    }

    void printStatus(){
        log(PRINT_CHARACTER_STATUS_PATTENR, getName(), getLife());
    }

    protected void targetSpell(Spell spell){
        target(spell.getPower());
    }
    protected void target(int power){
        life-=power;
        if(life<0)life=0;
        targetSpellStatus();
    }

    private void targetSpellStatus(){
        if(getLife()==0){
            log(TARGET_SPELL_PATTERN, getName(), getTextAfterDied());
        }else{
            log(TARGET_SPELL_PATTERN, getName(), getTextStillAlife());
        }
    }

    private int getLife(){
        return life;
    }

}
