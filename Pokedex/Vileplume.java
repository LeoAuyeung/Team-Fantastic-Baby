//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Vileplume.java
package Pokedex;

public class Vileplume extends Gloom {
	
	//Constructor
    public Vileplume() {
		super("Vileplume", 36, 101, 0);
		addMove("Solar Beam");
	}
	
	//Constructor for trainers
	public Vileplume( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Vileplume( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Solar Beam");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}