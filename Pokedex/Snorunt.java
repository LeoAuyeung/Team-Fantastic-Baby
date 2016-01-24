//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Snorunt.java
package Pokedex;

public class Snorunt extends Pokemon {
	
	//Constructor
	public Snorunt() {
		super("Snorunt", 25, 42, "ICE");
		addMove("Ice Shard");
		addMove("Ice Fang");
	}
	
	//Constructor for evolutions
	public Snorunt( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ICE");
		addMove("Ice Shard");
		addMove("Ice Fang");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}