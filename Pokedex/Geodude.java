//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Geodude.java
package Pokedex;

public class Geodude extends Pokemon {
	
	//Constructor
	public Geodude() {
		super("Geodude", 5, 25, "ROCK");
		addMove("Rollout");
		addMove("Rock Throw");
	}
	
	//Constructor for evolutions
	public Geodude( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ROCK");
		addMove("Rollout");
		addMove("Rock Throw");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}