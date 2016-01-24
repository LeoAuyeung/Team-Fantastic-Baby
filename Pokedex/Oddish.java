//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Oddish.java
package Pokedex;

public class Oddish extends Pokemon {
	
	//Constructor
	public Oddish() {
		super( "Oddish", 5, 21, "GRASS" );
		addMove("Seed Bomb");
		addMove("Razor Leaf");
	}
	
	//Constructor for trainers
	public Oddish( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Oddish( String n, int lvl, int eLvl) {
		super( n, lvl, eLvl, "GRASS" );
		addMove("Seed Bomb");
		addMove("Razor Leaf");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}
