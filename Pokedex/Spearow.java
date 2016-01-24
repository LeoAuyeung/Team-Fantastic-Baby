//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Spearow.java
package Pokedex;

public class Spearow extends Pokemon {
	
	//Constructor
	public Spearow() {
		super("Spearow", 5, 20, "FLYING");
		addMove("Peck");
		addMove("Aerial Ace");
	}
	
	//Constructor for trainers
	public Spearow( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Spearow( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FLYING");
		addMove("Peck");
		addMove("Aerial Ace");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}