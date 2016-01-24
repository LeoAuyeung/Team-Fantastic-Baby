//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Lairon.java
package Pokedex;

public class Lairon extends Aron {
	
	//Constructor
    public Lairon() {
		super("Lairon", 32, 42);
		addMove("Iron Tail");
	}
	
	//Constructor for trainers
	public Lairon( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Lairon( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Iron Tail");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}