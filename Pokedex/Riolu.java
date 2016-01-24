//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Riolu.java
package Pokedex;

public class Riolu extends Pokemon {
	
	//Constructor
	public Riolu() {
		super("Riolu", 16, 34, "FIGHTING");
		addMove("Force Palm");
		addMove("Brick Break");
	}
	
	//Constructor for trainers
	public Riolu( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Riolu( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "FIGHTING");
		addMove("Force Palm");
		addMove("Brick Break");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}