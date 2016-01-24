//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Raticate.java
package Pokedex;

public class Raticate extends Rattata {
	
	//Constructor
    public Raticate() {
		super("Raticate", 20, 101);
		addMove("Hyper Fang");
	}
	
	//Constructor for trainers
	public Raticate( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Raticate( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Hyper Fang");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}