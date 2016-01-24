//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Magnemite.java
package Pokedex;

public class Magnemite extends Pokemon {
	
	//Constructor
	public Magnemite() {
		super("Magnemite", 16, 30, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Spark");
	}
	
	//Constructor for trainers
	public Magnemite( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Magnemite( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Spark");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}