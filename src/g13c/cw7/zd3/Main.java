package g13c.cw7.zd3;

import g13c.cw7.zd3.harrypotter.Child;
import g13c.cw7.zd3.harrypotter.Dumbledore;
import g13c.cw7.zd3.harrypotter.Location;
import g13c.cw7.zd3.harrypotter.Orphanage;
import g13c.cw7.zd3.harrypotter.Potter;
import g13c.cw7.zd3.harrypotter.Riddle;
import g13c.cw7.zd3.harrypotter.Spell;
import g13c.cw7.zd3.harrypotter.StoryViolationException;
import g13c.cw7.zd3.harrypotter.Voldemort;
import g13c.cw7.zd3.harrypotter.Character;

public class Main {

    public static void main(String[] args) {
        Child tom = new Riddle("Tom Marvolo Riddle", Location.England);
        Orphanage woolsOrphanage = new Orphanage("Wool's Orphanage", Location.London);

        woolsOrphanage.addChild(tom);
        if (tom.getLocation() != Location.London) {
            throw new StoryViolationException("Tom Riddle should be in London");
        }
        Dumbledore albus = new Dumbledore("Albus Percival Wulfric Brian Dumbledore", Location.England);
        albus.moveTo(woolsOrphanage);

        tom.introduce();
        albus.introduce();

        Character.MoveAllTo(Location.Hogwarts, tom, albus);

        albus.say("Do you have anything to tell me?", tom);
        tom.say("No, professor.", albus);

        Voldemort youKnowWho = new Voldemort((Riddle) tom);
        youKnowWho.createHorcruxes(7);
        youKnowWho.printHorcruxes();

        Character lily = new Potter("Lily", Location.GodricsHollow);
        Character james = new Potter("James", Location.GodricsHollow);
        Child harry = new Potter("Harry", Location.GodricsHollow);

        lily.doSth("hiding");
        james.doSth("hiding");
        harry.doSth("hiding");

        try {
            youKnowWho.moveTo(Location.Hogwarts);
        } catch (StoryViolationException e) {
            e.printMessage();
        }

        Character.status();

        youKnowWho.moveTo(Location.GodricsHollow);

        youKnowWho.target(james);
        youKnowWho.target(lily);
        youKnowWho.target(harry);

        Character.doSth("defending", lily, james, harry);
        albus.doSth("drinking evening tea");

        youKnowWho.castSpell(Spell.AvadaKedavra);

        youKnowWho.createHorcruxes(1);
        youKnowWho.printHorcruxes();

        Character.status();

        albus.doSth("finish drinking tea");
        albus.moveTo(Location.GodricsHollow);
        albus.say("You are a wizzard, Harry", harry);
    }
/* OUTPUT:

Hello, I am Tom Marvolo Riddle
Hello, I am Albus Percival Wulfric Brian Dumbledore
Albus Percival Wulfric Brian Dumbledore to Tom Marvolo Riddle
	Do you have anything to tell me?
Tom Marvolo Riddle to Albus Percival Wulfric Brian Dumbledore
	No, professor.
Created horcruxes:
	horcrux 1
	horcrux 2
	horcrux 3
	horcrux 4
	horcrux 5
	horcrux 6
	horcrux 7
I am Lily, I am hiding
I am James, I am hiding
I am Harry, I am hiding
====Status====
Lily : 100
James : 100
Lord Voldemort : 100
Harry : 100
Albus Percival Wulfric Brian Dumbledore : 100
==============
I am Lily, I am defending
I am James, I am defending
I am Harry, I am defending
I am Albus Percival Wulfric Brian Dumbledore, I am drinking evening tea
James died.
Lily died.
Harry goes LOL...
Lord Voldemort died.
Created horcruxes:
	horcrux 1
	horcrux 2
	horcrux 3
	horcrux 4
	horcrux 5
	horcrux 6
	horcrux 7
	horcrux 8
====Status====
Lily : 0
James : 0
Lord Voldemort : 0
Harry : 100
Albus Percival Wulfric Brian Dumbledore : 100
==============
I am Albus Percival Wulfric Brian Dumbledore, I am finish drinking tea
Albus Percival Wulfric Brian Dumbledore to Harry
	You are a wizzard, Harry

*/
}
