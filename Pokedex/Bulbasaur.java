//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Bulbasaur.java
package Pokedex;

public class Bulbasaur extends Pokemon {
	
	//Constructor
	public Bulbasaur() {
		super( "Bulbasaur", 5, "GRASS" );
		addMove("Vine Whip", 45, 25);
		addMove("Magical Leaf", 60, 20);
	}
	
	//Constructor for evolutions
	public Bulbasaur( String n, int lvl) {
		super( n, lvl, "GRASS" );
		addMove("Vine Whip", 45, 25); // movesName, dmg, pp
		addMove("Magical Leaf", 60, 20);
	}
	
	//Pokedex description
	public String about() {
		return "Bulbasaur can be seen napping in bright sunlight. " + 
		"There is a seed on its back. " + 
		"By soaking up the sun's rays, the seed grows progressively larger.";
	}
	
}