//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Magnezone.java
package Pokedex;

public class Magnezone extends Magneton {
	
	//Constructor
    public Magnezone() {
		super("Magnezone", 45, 101, 0);
		addMove("Zap Cannon");
	}
	
	//Constructor for evolutions
	public Magnezone( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Zap Cannon");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}