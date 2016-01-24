//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Machamp.java
package Pokedex;

public class Machamp extends Machoke {
	
	//Constructor
    public Machamp() {
		super("Machamp", 44, 101, 0);
		addMove("Dynamic Punch");
	}
	
	//Constructor for trainers
	public Machamp( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Machamp( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Dynamic Punch");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}