//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Electivire.java
package Pokedex;

public class Electivire extends Electabuzz {
	
	//Constructor
    public Electivire() {
		super("Electivire", 45, 101, 0);
		addMove("Thunder");
	}
	
	//Constructor for trainers
	public Electivire( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Electivire( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Thunder");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}