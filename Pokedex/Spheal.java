//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Spheal.java
package Pokedex;

public class Spheal extends Pokemon {
	
	//Constructor
	public Spheal() {
		super("Spheal", 12, 32, "ICE");
		addMove("Powder Snow");
		addMove("Aurora Beam");
	}
	
	//Constructor for trainers
	public Spheal( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Spheal( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ICE");
		addMove("Powder Snow");
		addMove("Aurora Beam");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}