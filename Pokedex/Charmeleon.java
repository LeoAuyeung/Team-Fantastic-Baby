//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charmeleon.java
package Pokedex;

public class Charmeleon extends Charmander {
	
	//Constructor
	public Charmeleon() {
		super("Charmeleon", 16, 36);
		addMove("Flamethrower");
	}
	
	//Constructor for trainers
	public Charmeleon( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Charmeleon( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Flamethrower");
	}
	
	//Pokedex description
	public String about() {
		return "CHARMELEON";
	}
	
}