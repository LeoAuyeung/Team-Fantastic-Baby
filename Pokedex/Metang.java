//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Metang.java
package Pokedex;

public class Metang extends Beldum {
	
	//Constructor
    public Metang() {
		super("Metang", 20, 45);
		addMove("Meteor Mash");
	}
	
	//Constructor for evolutions
	public Metang( String n, int lvl, int eLvl, int xp ) {
		super( n, lvl, eLvl );
		exp = xp;
		addMove("Meteor Mash");
	}
	
    public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}