//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Machoke.java
package Pokedex;

public class Machoke extends Machop {
	
	//Constructor
    public Machoke() {
		super("Machoke", 28, 44);
		addMove("Submission");
	}
	
	//Constructor for trainers
	public Machoke( int lvl ) {
		this();
		level = lvl;
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