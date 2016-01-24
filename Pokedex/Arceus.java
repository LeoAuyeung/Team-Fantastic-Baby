//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Arceus.java
package Pokedex;

public class Arceus extends Pokemon {
	
	//Constructor
	public Arceus() {
		super("Arceus", 75, 101, "NORMAL");
		addMove("Echoed Voice");
		addMove("Hyper Voice");
		addMove("Judgement");
		addMove("Hyper Beam");
	}
	
	//Constructor for trainers
	public Arceus( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Arceus";
	}
	
}