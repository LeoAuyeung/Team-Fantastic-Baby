//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Machoke.java
package Pokedex;

public class Machoke extends Pokemon {
	
	//Constructor
    public Machoke() {
		super("Machoke", 28, 44);
		addMove("Submission");
	}
	
	//Constructor for evolutions
	public Machoke( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Submission");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}