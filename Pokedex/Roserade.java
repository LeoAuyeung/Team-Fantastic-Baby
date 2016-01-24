//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Roserade.java
package Pokedex;

public class Roserade extends Roselia {
	
	//Constructor
    public Roserade() {
		super("Roserade", 36, 101, 0);
		addMove("Solar Beam");
	}
	
	//Constructor for trainers
	public Roserade( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Roserade( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Solar Beam");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}