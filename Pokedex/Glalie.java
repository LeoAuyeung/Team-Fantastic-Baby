//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Glalie.java
package Pokedex;

public class Glalie extends Snorunt {
	
	//Constructor
    public Glalie() {
		super("Glalie", 42, 101);
		addMove("Ice Beam");
	}
	
	//Constructor for evolutions
	public Glalie( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Ice Beam");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}