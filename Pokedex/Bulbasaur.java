//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Bulbasaur.java
package Pokedex;

public class Bulbasaur extends Pokemon {
	
	//Constructor
	public Bulbasaur() {
		super( "Bulbasaur", 5, "GRASS" );
		addMove("Vine Whip");
		addMove("Magical Leaf");
	}
	
	//Constructor for evolutions
	public Bulbasaur( String n, int lvl) {
		super( n, lvl, "GRASS" );
		addMove("Vine Whip");
		addMove("Magical Leaf");
	}
	
	//Pokedex description
	public String about() {
		return "Bulbasaur can be seen napping in bright sunlight. \n" + 
		"There is a seed on its back. \n" + 
		"By soaking up the sun's rays, the seed grows progressively larger.";
	}
	
}