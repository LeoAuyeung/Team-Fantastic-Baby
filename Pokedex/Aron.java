//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Aron.java
package Pokedex;

public class Aron extends Pokemon {
	
	//Constructor
	public Aron() {
		super("Aron", 5, 32, "STEEL");
		addMove("Metal Claw");
		addMove("Iron Head");
	}
	
	//Constructor for evolutions
	public Aron( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "STEEL");
		addMove("Metal Claw");
		addMove("Iron Head");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}