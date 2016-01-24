//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charizard.java
package Pokedex;

public class Charizard extends Charmeleon {
	
	//Constructor
	public Charizard() {
		super("Charizard", 36, 101, 0);
		addMove("Blast Burn");
	}
	
	//Constructor for evolutions
	public Charizard( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Blast Burn");
	}
	
	//Pokedex description
	public String about() {
		return "Charizard";
	}
	
}