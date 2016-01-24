//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Houndour.java
package Pokedex;

public class Houndour extends Pokemon {
	
	//Constructor
	public Houndour() {
		super("Houndour", 5, 24, "DARK");
		addMove("Pursuit");
		addMove("Bite");
	}
	
	//Constructor for trainers
	public Houndour( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Houndour( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "DARK");
		addMove("Pursuit");
		addMove("Bite");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}