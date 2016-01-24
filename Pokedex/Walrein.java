//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Walrein.java
package Pokedex;

public class Walrein extends Sealeo {
	
	//Constructor
    public Walrein() {
		super("Walrein", 44, 101, 0);
		addMove("Blizzard");
	}
	
	//Constructor for evolutions
	public Walrein( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Blizzard");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}