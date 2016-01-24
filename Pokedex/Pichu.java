//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pichu.java
package Pokedex;

public class Pichu extends Pokemon {
	
	//Constructor
	public Pichu() {
		super("Pichu", 5, 16, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Spark");
	}
	
	//Constructor for evolutions
	public Pichu( String n, int lvl, int eLvl ) {
		super( n, lvl, eLvl, "ELECTRIC");
		addMove("Thunder Shock");
		addMove("Spark");
	}
	
	//Pokedex description
	public String about() {
		return "Made by Leo Au-Yeung and Sungbin Kim";
	}
	
}