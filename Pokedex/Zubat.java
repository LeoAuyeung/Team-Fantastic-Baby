//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Zubat.java
package Pokedex;

public class Zubat extends Pokemon {
	
	//Constructor
	public Zubat() {
		super("Zubat", 5, 22, "FLYING");
		addMove("Gust");
		addMove("Wing Attack");
	}
	
	//Constructor for trainers
	public Zubat( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Zubat( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FLYING");
		addMove("Gust");
		addMove("Wing Attack");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}