//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Magikarp.java
package Pokedex;

public class Magikarp extends Pokemon {
	
	//Constructor
	public Magikarp() {
		super("Magikarp", 5, 20, "WATER");
		addMove("Splash");
		addMove("Water Pulse");
	}
	
	//Constructor for trainers
	public Magikarp( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Magikarp( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "WATER");
		addMove("Splash");
		addMove("Water Pulse");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}