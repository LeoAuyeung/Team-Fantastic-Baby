//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Squirtle.java
package Pokedex;

public class Squirtle extends Pokemon {
	
	//Constructor
	public Squirtle() {
		super( "Squirtle", 5, 16, "WATER" );
		addMove("Water Gun");
		addMove("Bubble Beam");
	}
	
	//Constructor for evolutions
	public Squirtle( String n, int lvl, int eLvl) {
		super( n, lvl, eLvl, "WATER" );
		addMove("Water Gun");
		addMove("Bubble Beam");
	}
	
	//Pokedex description
	public String about() {
		return "Squirtle's shell is not merely used for protection. \n" +
		"The shell's rounded shape and the grooves on its surface help minimize resistance in water, \n" + 
		"enabling this Pokémon to swim at high speeds.";
	}
	
}
