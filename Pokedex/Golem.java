//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Golem.java
package Pokedex;

public class Golem extends Graveler {
	
	//Constructor
    public Golem() {
		super("Golem", 44, 101, 0);
		addMove("Stone Edge");
	}
	
	//Constructor for trainers
	public Golem( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Golem( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Stone Edge");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}