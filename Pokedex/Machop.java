//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Machop.java
package Pokedex;

public class Machop extends Pokemon {
	
	//Constructor
	public Machop() {
		super("Machop", 5, 28, "FIGHTING");
		addMove("Low Kick");
		addMove("Karate Chop");
	}
	
	//Constructor for trainers
	public Machop( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Machop( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FIGHTING");
		addMove("Low Kick");
		addMove("Karate Chop");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}