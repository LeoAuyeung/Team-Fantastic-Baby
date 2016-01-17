//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Squirtle.java
package Pokedex;

public class Squirtle extends Pokemon {
	
	//Constructor
	public Squirtle() {
		super("Squirtle", 100, 50, 50, 25, 5, 100, "WATER");
	}
	
	//Constructor with nickname
	public Squirtle( String nick ) {
		super(nick, 100, 50, 50, 25, 5, 100, "WATER");
	}
	
	//Pokedex description
	public String about() {
		return "Squirtle's shell is not merely used for protection. " +
		"The shell's rounded shape and the grooves on its surface help minimize resistance in water, " + 
		"enabling this Pokémon to swim at high speeds.";
	}
	
}
