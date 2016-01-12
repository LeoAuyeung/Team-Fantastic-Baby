//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
	public void startupMsg() {
		//startup message from original Pokemon games!
		
		//***ADD WAIT TIME LATER TO DELAY MESSAGES***
		
		System.out.println("\nHello there! It's a pleasure to meet you!\n");
		System.out.println("Welcome to the world of Pokemon!");
		System.out.println("My name is Oak, but everyone just calls me the Pokemon Professor.\n");
		System.out.println("This world is widely inhabited by creatures known as Pokemon.");
		System.out.println("We humans live alongside Pokemon as friends.");
		System.out.println("At times we play together, and at other times we work together.");
		System.out.println("Some people use their Pokemon to battle and develop close bonds with them.\n");
		System.out.println("And what do I do? I conduct research so that we may learn more about Pokemon.");
		System.out.println("Now, why don't you tell me a little bit about yourself?\n");
	}
	
	public String promptGender() {
		String gen = "";
		System.out.println("Are you a boy? Or are you a girl?");
		gen = Keyboard.readString();
		return gen;
	}
	
	public String promptName() {
		String name = "";
		System.out.println("All right. Tell me, what is your name?");
		name = Keyboard.readString();
		return name;
	}
	
	public int promptStarter() {
		int pkmn = 0;
		System.out.println("In this world of Pokemon, you'll need a partner Pokemon to be with you.");
		System.out.println("Tell me, which Pokemon would you like to be your partner?");
		System.out.println("1. Charmander\t2. Squirtle\t3. Bulbasaur");
		pkmn = Keyboard.readInt();
		return pkmn;
	}
	
	public String promptControl() {
		String ctrl = "";
		System.out.print("Enter a control: ");
		ctrl = Keyboard.readString();
		return ctrl;
	}
	
	public void displayMap() {
		//implementation to display map and player
	}
	
	public void executeControl() {
		//List of controls to implement: W,A,S,D (movement), X (interact with object in front), 
	}
	
	public void play() {
		//startup prompt; only prompts user once
		startupMsg();
		String gender = promptGender();
		String name = promptName();
		Player user = new Player(gender, name);
		int starter = promptStarter();
		if (starter == 1) { Pokemon baws = new Charmander(); } //getting the basics down first
		
		Map test = new Map();
		
		while ( user.getQuest() != 20 ) {
			//displayMap();
			//prompt user for a command
			String control = promptControl();
			//executeControl();
		}
	}
	
	public static void main (String[] args) {
		Game pkmn = new Game();
		pkmn.play();
	}
	
}

