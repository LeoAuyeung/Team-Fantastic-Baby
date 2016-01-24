//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Darkrai.java
package Pokedex;

public class Darkrai extends Pokemon {
	
	//Constructor
	public Darkrai() {
		super("Darkrai", 40, 101, "DARK");
		addMove("Feint Attack");
		addMove("Dark Pulse");
		addMove("Foul Play");
		addMove("Dark Void");
	}
	
	//Constructor for trainers
	public Darkrai( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Darkrai";
	}
	
}