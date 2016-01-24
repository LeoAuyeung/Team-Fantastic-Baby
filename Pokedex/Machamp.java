//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Machoke.java
package Pokedex;

public class Machoke extends Pokemon {
	
	//Constructor
    public Machoke() {
		super("Machoke", 44, 101, 0);
		addMove("Dynamic Punch");
	}
	
	//Constructor for evolutions
	public Machoke( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl, xp );
		addMove("Dynamic Punch");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}