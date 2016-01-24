//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Sharpedo.java
package Pokedex;

public class Sharpedo extends Carvanha {
	
	//Constructor
    public Sharpedo() {
		super("Sharpedo", 30, 101);
		addMove("Hydro Pump");
	}
	
	//Constructor for evolutions
	public Sharpedo( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Hydro Pump");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}