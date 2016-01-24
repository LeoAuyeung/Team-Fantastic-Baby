//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Mightyena.java
package Pokedex;

public class Mightyena extends Poochyena {
	
	//Constructor
    public Mightyena() {
		super("Mightyena", 18, 101);
		addMove("Crunch");
	}
	
	//Constructor for evolutions
	public Mightyena( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Crunch");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}