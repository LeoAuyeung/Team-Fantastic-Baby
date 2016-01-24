//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Blastoise.java
package Pokedex;

public class Blastoise extends Pokemon {
	
	//Constructor
    public Blastoise() {
		super("Blastoise", 36, 101, 0);
		addMove("Hydro Cannon");
	}
	
	//Constructor for evolutions
	public Blastoise( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Hydro Cannon");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}