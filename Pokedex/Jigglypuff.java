//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Jigglypuff.java
package Pokedex;

public class Jigglypuff extends Pokemon {
	
	//Constructor
    public Jigglypuff() {
		super("Jigglypuff", 5, 16, "NORMAL");
		addMove("Pound");
		addMove("Wake-Up Slap");
	}
	
	//Constructor for trainers
	public Jigglypuff( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Jigglypuff( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "NORMAL" );
		addMove("Pound");
		addMove("Wake-Up Slap");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}