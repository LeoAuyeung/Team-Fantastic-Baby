//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Venusaur.java
package Pokedex;

public class Venusaur extends Ivysaur {
	
	//Constructor
	public Venusaur() {
		super( "Venusaur", 32, 101, 0);
		addMove("Frenzy Plant");
	}
	
	//Constructor for evolutions
	public Venusaur( String n, int lvl, int eLvl, int xp) {
		super( n, lvl, eLvl, xp );
		addMove("Frenzy Plant");
	}
	
	//Pokedex description
	public String about() {
		return "Venusaur";
	}
	
}