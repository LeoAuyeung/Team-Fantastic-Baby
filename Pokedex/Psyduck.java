//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Psyduck.java
package Pokedex;

public class Psyduck extends Pokemon {
	
	//Constructor
	public Psyduck() {
		super("Psyduck", 16, 33, "WATER");
		addMove("Water Gun");
		addMove("Water Pulse");
	}
	
	//Constructor for trainers
	public Psyduck( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Psyduck( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "WATER" );
		addMove("Water Gun");
		addMove("Water Pulse");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}