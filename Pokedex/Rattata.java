//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Rattata.java
package Pokedex;

public class Rattata extends Pokemon {
	
	//Constructor
	public Rattata() {
		super("Rattata", 50, 25, 25, 10, 5, "NORMAL");
	}
	
	//Constructor with nickname
	public Rattata( String nick ) {
		super(nick, 50, 25, 25, 10, 5, "NORMAL");
	}
	
	//Pokedex description
	public String about() {
		return "Rattata is cautious in the extreme. " +
		"Even while it is asleep, it constantly listens by moving its ears around. " +
		"It is not picky about where it lives—it will make its nest anywhere.";
	}
	
}