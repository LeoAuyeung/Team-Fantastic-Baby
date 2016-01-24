//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Regice.java
package Pokedex;

public class Regice extends Pokemon {
	
	//Constructor
	public Regice() {
		super("Regice", 35, 101, "ICE");
		addMove("Frost Breath");
		addMove("Icy Wind");
		addMove("Ice Beam");
		addMove("Blizzard");
	}
	
	//Constructor for trainers
	public Regice( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Regice";
	}
	
}