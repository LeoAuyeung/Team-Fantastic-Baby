//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Golbat.java
package Pokedex;

public class Golbat extends Zubat {
	
	//Constructor
    public Golbat() {
		super("Golbat", 44, 101, 0);
		addMove("Sky Attack");
	}
	
	//Constructor for evolutions
	public Golbat( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Sky Attack");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}