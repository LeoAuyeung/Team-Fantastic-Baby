//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Zigzagoon.java
package Pokedex;

public class Zigzagoon extends Pokemon {
	
	//Constructor
    public Zigzagoon() {
		super("Zigzagoon", 5, 20, "NORMAL");
		addMove("Tackle");
		addMove("Headbutt");
	}
	
	//Constructor for trainers
	public Zigzagoon( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Zigzagoon( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "NORMAL" );
		addMove("Tackle");
		addMove("Headbutt");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}