//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Ninetales.java
package Pokedex;

public class Ninetales extends Vulpix {
	
	//Constructor
    public Ninetales() {
		super("Ninetales", 16, 36);
		addMove("Flamethrower");
	}
	
	//Constructor for evolutions
	public Ninetales( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Flamethrower");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}