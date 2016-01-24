//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Carvanha.java
package Pokedex;

public class Carvanha extends Pokemon {
	
	//Constructor
	public Carvanha() {
		super("Carvanha", 16, 30, "WATER");
		addMove("Aqua Jet");
		addMove("Water Pulse");
	}
	
	//Constructor for trainers
	public Carvanha( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Carvanha( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "WATER");
		addMove("Aqua Jet");
		addMove("Water Pulse");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}