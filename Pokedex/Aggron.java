//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Aggron.java
package Pokedex;

public class Aggron extends Lairon {
	
	//Constructor
    public Aggron() {
		super("Aggron", 42, 101, 0);
		addMove("Metal Burst");
	}
	
	//Constructor for trainers
	public Aggron( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Aggron( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Metal Burst");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}