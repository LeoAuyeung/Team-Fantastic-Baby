//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Golbat.java
package Pokedex;

public class Golbat extends Zubat {
	
	//Constructor
    public Golbat() {
		super("Golbat", 22, 44);
		addMove("Air Slash");
	}
	
	//Constructor for trainers
	public Golbat( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Golbat( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Air Slash");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}