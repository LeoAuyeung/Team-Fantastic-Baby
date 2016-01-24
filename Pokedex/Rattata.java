//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Rattata.java
package Pokedex;

public class Rattata extends Pokemon {
	
	//Constructor
	public Rattata() {
		super( "Rattata", 5, 20, "NORMAL" );
		addMove("Tackle");
		addMove("Scratch");
	}
	
	//Constructor for trainers
	public Rattata( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Rattata( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "NORMAL" );
		addMove("Tackle");
		addMove("Scratch");
	}
	
	//Pokedex description
	public String about() {
		return "Rattata is cautious in the extreme. \n" +
		"Even while it is asleep, it constantly listens by moving its ears around. \n" +
		"It is not picky about where it lives—it will make its nest anywhere.";
	}
	
}