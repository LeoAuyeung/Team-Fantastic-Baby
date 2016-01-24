//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Golduck.java
package Pokedex;

public class Golduck extends Psyduck {
	
	//Constructor
    public Golduck() {
		super("Golduck", 33, 101);
		addMove("Aqua Tail");
	}
	
	//Constructor for trainers
	public Golduck( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Golduck( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Aqua Tail");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}