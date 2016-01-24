//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Growlithe.java
package Pokedex;

public class Growlithe extends Pokemon {
	
	//Constructor
    public Growlithe() {
		super("Growlithe", 5, 16, "FIRE");
		addMove("Ember");
		addMove("Fire Fang");
	}
	
	//Constructor for trainers
	public Growlithe( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Growlithe( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FIRE" );
		addMove("Ember");
		addMove("Fire Fang");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}