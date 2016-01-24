//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Elekid.java
package Pokedex;

public class Elekid extends Pokemon {
	
	//Constructor
	public Elekid() {
		super("Elekid", 16, 30, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Shock Wave");
	}
	
	//Constructor for trainers
	public Elekid( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Elekid( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Shock Wave");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}