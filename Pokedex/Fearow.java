//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Fearow.java
package Pokedex;

public class Fearow extends Spearow {
	
	//Constructor
    public Fearow() {
		super("Fearow", 20, 101);
		addMove("Drill Peck");
	}
	
	//Constructor for evolutions
	public Fearow( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Drill Peck");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}