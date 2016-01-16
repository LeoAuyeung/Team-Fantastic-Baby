//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charmander.java
package Pokedex;

public class Charmander extends Pokemon {
	
	//Constructor
	public Charmander() {
		super("Charmander", 100, 50, 50, 25, 5, "FIRE");
	}
	
	//Constructor with nickname
	public Charmander( String nick ) {
		super(nick, 100, 50, 50, 25, 5, "FIRE");
	}
	
	//Pokedex description
	public String about() {
		return "The flame that burns at the tip of its tail is an indication of its emotions. " +
		"The flame wavers when Charmander is enjoying itself. " +
		"If the Pokemon becomes enraged, the flame burns fiercely.";
	}
	
}
