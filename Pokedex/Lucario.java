//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Lucario.java
package Pokedex;

public class Lucario extends Riolu {
	
	//Constructor
    public Lucario() {
		super("Lucario", 34, 101);
		addMove("Sky Uppercut");
	}
	
	//Constructor for trainers
	public Lucario( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Lucario( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Sky Uppercut");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}