//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Rayquaza.java
package Pokedex;

public class Rayquaza extends Pokemon {
	
	//Constructor
	public Rayquaza() {
		super("Rayquaza", 65, 101, "FLYING");
		addMove("Sky Drop");
		addMove("Tail Wind");
		addMove("Aerial Ace");
		addMove("Dragon Ascent");
	}
	
	//Constructor for trainers
	public Rayquaza( int lvl ) {
		this();
		level = lvl;
	}
	
	//Pokedex description
	public String about() {
		return "Rayquaza";
	}
	
}