//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Wigglytuff.java
package Pokedex;

public class Wigglytuff extends Jigglypuff {
	
	//Constructor
    public Wigglytuff() {
		super("Wigglytuff", 16, 101);
		addMove("Body Slam");
	}
	
	//Constructor for trainers
	public Wigglytuff( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Wigglytuff( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Body Slam");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}