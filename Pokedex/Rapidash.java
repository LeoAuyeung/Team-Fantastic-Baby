//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Rapidash.java
package Pokedex;

public class Rapidash extends Ponyta {
	
	//Constructor
    public Rapidash() {
		super("Rapidash", 32, 101);
		addMove("Inferno");
	}
	
	//Constructor for evolutions
	public Rapidash( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Inferno");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}