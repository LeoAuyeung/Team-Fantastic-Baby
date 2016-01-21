//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Squirtle.java
package Pokedex;

public class Oddish extends Pokemon {
	
	//Constructor
	public Oddish() {
		super( "Oddish", 5, "GRASS" );
		addMove("Razor Leaf");
		addMove("Seed Bomb");
	}
	
	//Constructor for evolutions
	public Oddish( String n, int lvl) {
		super( n, lvl, "GRASS" );
		addMove("Razor Leaf");
		addMove("Seed Bomb");
	}
	
	//Pokedex description
	public String about() {
		return "During the daytime, Oddish buries itself in soil to absorb nutrients from the ground using its entire body. \t"
		+ "The more fertile the soil, the glossier its leaves become.";
	}
	
}
