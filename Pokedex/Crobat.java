//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Crobat.java
package Pokedex;

public class Crobat extends Golbat {
	
	//Constructor
    public Crobat() {
		super("Crobat", 44, 101, 0);
		addMove("Sky Attack");
	}
	
	//Constructor for evolutions
	public Crobat( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Sky Attack");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}