//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Ponyta.java
package Pokedex;

public class Ponyta extends Pokemon {
	
	//Constructor
    public Ponyta() {
		super("Ponyta", 12, 32, "FIRE");
		addMove("Ember");
		addMove("Flame Charge");
	}
	
	//Constructor for trainers
	public Ponyta( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Ponyta( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FIRE" );
		addMove("Ember");
		addMove("Flame Charge");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}