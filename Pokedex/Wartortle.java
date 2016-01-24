//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Wartortle.java
package Pokedex;

public class Wartortle extends Squirtle {
	
	//Constructor
    public Wartortle() {
		super("Wartortle", 16, 36);
		addMove("Aqua Tail");
	}
	
	//Constructor for trainers
	public Wartortle( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Wartortle( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Aqua Tail");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}