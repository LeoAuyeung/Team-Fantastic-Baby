//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Mewtwo.java
package Pokedex;

public class Mewtwo extends Pokemon {
	
	//Constructor
	public Mewtwo() {
		super("Mewtwo", 55, 101, "FIGHTING");
		addMove("Swift");
		addMove("Hidden Power");
		addMove("Psystrike");
		addMove("Hyper Beam");
	}
	
	//Constructor for trainers
	public Mewtwo( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Mewtwo";
	}
	
}