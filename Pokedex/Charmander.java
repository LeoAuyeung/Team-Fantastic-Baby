//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charmander.java
package Pokedex;

public class Charmander extends Pokemon {
	
	//Constructor
	public Charmander() {
		super("Charmander", 5, "FIRE");
		addMove("Ember");
		addMove("Fire Punch");
	}
	
	//Constructor for evolutions
	public Charmander( String n, int lvl) {
		super( n, lvl, "FIRE");
		addMove("Ember");
		addMove("Fire Punch");
	}
	
	//Pokedex description
	public String about() {
		return "The flame that burns at the tip of its tail is an indication of its emotions. " +
		"The flame wavers when Charmander is enjoying itself. " +
		"If the Pokemon becomes enraged, the flame burns fiercely.";
	}
	
}
