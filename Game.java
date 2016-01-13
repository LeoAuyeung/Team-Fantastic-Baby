//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
	private boolean battleMode = false;
	
	public void startupMsg() {
		//startup message from original Pokemon games!
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//***ADJUST WAIT TIMES LATER***
		
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		System.out.println("\nHello there! It's a pleasure to meet you!");
		System.out.println("\nWelcome to the world of Pokemon!");
		System.out.println("\nMy name is Oak, but everyone just calls me the Pokemon Professor.");
		System.out.println("\nThis world is widely inhabited by creatures known as Pokemon.");
		System.out.println("\nWe humans live alongside Pokemon as friends.");
		System.out.println("At times we play together, and at other times we work together.");
		System.out.println("Some people use their Pokemon to battle and develop close bonds with them.\n");
		System.out.println("And what do I do? I conduct research so that we may learn more about Pokemon.");
		System.out.println("Now, why don't you tell me a little bit about yourself?\n");
	}
	
	//method to wait a # of milliseconds; used mainly for recreating feel of actual game
	public void waitMS( int milliseconds ) {
		try { Thread.sleep( milliseconds ); } 
		catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	//method to prompt gender of player
	public String promptGender() {
		String gen = "";
		System.out.println("Tell me, are you a boy? Or are you a girl?");
		gen = Keyboard.readString();
		return gen;
	}
	
	//method to prompt name of player
	public String promptName() {
		String name = "";
		System.out.println("All right. Tell me, what is your name?");
		name = Keyboard.readString();
		//restricts name to 12 characters; can change if necessary
		if (name.length() > 15) {
			name = name.substring(0,16);
		}
		return name;
	}
	
	//method to prompt player to pick his/her starter Pokemon
	public int promptStarter() {
		int pkmn = 0;
		System.out.println("In this world of Pokemon, you'll need a partner Pokemon to be with you.");
		System.out.println("Tell me, which Pokemon would you like to be your partner?");
		System.out.println("1. Bulbasaur\t2. Charmander\t3. Squirtle");
		pkmn = Keyboard.readInt();
		//ADD CASE WHERE INT IS NOT 1-3 OR IS INVALID
		return pkmn;
	}
	
	//method to prompt user for a command
	public String promptControl() {
		String ctrl = "";
		System.out.print("Enter a control: ");
		ctrl = Keyboard.readString();
		return ctrl;
	}
	
	//method to display map
	public void displayMap() {
		//implementation to display map and player
		displayCommands();
	}
	
	//method to display Pokemon battle
	public void displayBattle() {
		//implementation to display battle
		displayCommands();
	}
	
	//method to display available commands depending on in battle or not
	public void displayCommands() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		if (battleMode == false) {
			//display walking commands/interactions
		}
		else if (battleMode == true) {
			//display battle commands
		}
	}
	
	//method to "clear" terminal
	public static void clearDisplay() {
		for( int n = 0; n < 50; n++ ) {
			System.out.println("");
		}
	}
	
	public void executeControl( String command ) {
		//LIST OF CONTROLS: http://pokemonessentials.wikia.com/wiki/Controls
		//SETTING PKMN CONTROLS: http://pokemonessentials.wikia.com/wiki/Tutorial:Set_the_Controls_Screen
		
		//creates a flag to check whether user has given a valid command
		boolean validCommand = false;
		
		//Valid commands out of battle
		if ( battleMode == false ) {
			while (validCommand == false) {
				//System.out.println("command: " + command); //debug purposes
				if ( command.toLowerCase().equals("w") ) { 
					validCommand = true;
					//user.setX, user.setY, change map's player coordinates
				}
				if ( command.toLowerCase().equals("a") ) {
					validCommand = true;
					//user.setX, user.setY, change map's player coordinates
				}
				if ( command.toLowerCase().equals("s") ) {
					validCommand = true;
					//user.setX, user.setY, change map's player coordinates
				}
				if ( command.toLowerCase().equals("d") ) {
					validCommand = true;
					//user.setX, user.setY, change map's player coordinates
				}
				if ( command.toLowerCase().equals("x") ) {
					validCommand = true;
					//check block in front using player.getDirection()
					//we will have: trees, rocks, walls, enemy trainers
				}
				else {
					System.out.println("Invalid command.");
					validCommand = true;
				}
			}
		}
		
		//Valid commands in a battle
		else if ( battleMode == true ) {
			while (validCommand == false) {
				if ( command.toLowerCase().equals("1") ) { //FIGHT
					validCommand = true;
					//fight
					//can also type "BACK" to go back
				}
				if ( command.toLowerCase().equals("2") ) { //BAG
					validCommand = true;
					//displayBag();
					//prompt user for another input to choose what to do
					//can also type "BACK" to go back
				}
				if ( command.toLowerCase().equals("3") ) { //POKEMON
					validCommand = true;
					//displayPokemon(); displays pkmn 1-6 with name + health
					//prompt user to pick which to choose (1-6)
					//can also type "BACK" to go back
				}
				if ( command.toLowerCase().equals("4") ) { //RUN
					validCommand = true;
					//checks if battle is a Trainer battle
					//if not, chance of running = http://bulbapedia.bulbagarden.net/wiki/Escape#Success_conditions
				}
				else {
					//PROBLEM: INPUT INVALID COMMAND --> OPPONENT'S TURN
					System.out.println("Invalid command.");
					validCommand = true;
				}
			}
			
			
			//opponentBattle(); //opposing Pokemon will always try to fight with 1 of its 4** moves
			
		}
		
	}//end executeControl()
	
	public void play() {
		//startup prompt; only prompts user once
		startupMsg();
		String gender = promptGender();
		String name = promptName();
		Player user = new Player(gender, name);
		
		//prompts for starter Pokemon, and creates one accordingly
		int starter = promptStarter();
		if (starter == 1) { Pokemon baws = new Bulbasaur(); }
		else if (starter == 2) { Pokemon baws = new Charmander(); }
		else if (starter == 3) { Pokemon baws = new Squirtle(); }
		
		Map test = new Map();
		
		//RUNS GAME:
		while ( user.getQuest() != 20 ) {
			//clearDisplay(); //comment out when debugging
			if ( battleMode == false ) { displayMap(); }
			else if ( battleMode == true ) { displayBattle();}
			
			//prompt user for a command
			String control = promptControl();
			executeControl( control );
		}
	}
	
	public static void main (String[] args) {
		Game pkmn = new Game();
		pkmn.play();
	}
	
}

