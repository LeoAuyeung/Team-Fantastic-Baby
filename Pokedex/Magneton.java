//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Magneton.java
package Pokedex;

public class Magneton extends Magnemite {
	
	//Constructor
    public Magneton() {
		super("Magneton", 30, 45);
		addMove("Discharge");
	}
	
	//Constructor for trainers
	public Magneton( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Magneton( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Discharge");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}