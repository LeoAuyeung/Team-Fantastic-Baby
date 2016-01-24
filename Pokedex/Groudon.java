//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Groudon.java
package Pokedex;

public class Groudon extends Pokemon {
	
	//Constructor
	public Groudon() {
		super("Groudon", 45, 101, "FIRE");
		addMove("Incinerate");
		addMove("Lava Plume");
		addMove("Eruption");
		addMove("Precipice Blades");
	}
	
	//Constructor for trainers
	public Groudon( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Groudon";
	}
	
}