//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Squirtle.java
package Pokedex;

public class Squirtle extends Pokemon {
	
	//Constructor
	public Squirtle() {
		super( "Squirtle", 5, "WATER" );
		addMove("Water Gun", 40, 25);
		addMove("Bubble Beam", 65, 20);
	}
	
	//Constructor for evolutions
	public Squirtle( String n, int lvl) {
		super( n, lvl, "WATER" );
		addMove("Water Gun", 40, 25); // movesName, dmg, pp
		addMove("Bubble Beam", 65, 20);
	}
	
	//Pokedex description
	public String about() {
		return "Squirtle's shell is not merely used for protection. " +
		"The shell's rounded shape and the grooves on its surface help minimize resistance in water, " + 
		"enabling this Pokémon to swim at high speeds.";
	}
	
}
