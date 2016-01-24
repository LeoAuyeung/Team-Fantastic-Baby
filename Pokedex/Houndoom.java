//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Houndoom.java
package Pokedex;

public class Houndoom extends Houndour {
	
	//Constructor
    public Houndoom() {
		super("Houndoom", 24, 101);
		addMove("Feint Attack");
	}
	
	//Constructor for trainers
	public Houndoom( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Houndoom( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Feint Attack");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}