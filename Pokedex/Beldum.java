//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Beldum.java
package Pokedex;

public class Beldum extends Pokemon {
	
	//Constructor
	public Beldum() {
		super("Beldum", 5, 20, "STEEL");
		addMove("Metal Claw");
		addMove("Iron Head");
	}
	
	//Constructor for evolutions
	public Beldum( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "STEEL");
		addMove("Metal Claw");
		addMove("Iron Head");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}