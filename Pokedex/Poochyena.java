//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Poochyena.java
package Pokedex;

public class Poochyena extends Pokemon {
	
	//Constructor
	public Poochyena() {
		super("Poochyena", 5, 18, "DARK");
		addMove("Pursuit");
		addMove("Bite");
	}
	
	//Constructor for evolutions
	public Poochyena( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "DARK");
		addMove("Pursuit");
		addMove("Bite");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}