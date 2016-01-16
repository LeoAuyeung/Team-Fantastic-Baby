//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import java.util.ArrayList;
import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
    private ArrayList<Pokemon> _Pokemon = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> _PokemonEnemy = new ArrayList<Pokemon>(); //Pokemon of enemy; can be reused whenever trainers battle **
    private int selectedPokemon;
    private boolean battleMode = false;
	private boolean opponentTurn = false; //this boolean will only get changed within a Pokemon battle
	
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
	
    //~~~~~~~~~~~~~~~PROMPTS~~~~~~~~~~~~~~~~~~~~~~~
	
    //method to prompt gender of player
    public String promptGender() {
		String gen = "";
		System.out.println("Tell me, are you a boy? Or are you a girl?");
		//ADD CASE WHERE INPUT IS INVALID
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
		ctrl = ctrl.toLowerCase();
		return ctrl;
	}
	
	//~~~~~~~~~~~~~~~DISPLAYS~~~~~~~~~~~~~~~~~~~~~~~
	
	//method to display Pokemon battle
	public void displayBattle() {
		System.out.println( Battle.getBattle() );
	}
	
	//method to display available commands depending on in battle or not
	public void displayCommands() {
		//LIST OF CONTROLS: http://pokemonessentials.wikia.com/wiki/Controls
		//SETTING POKEMON CONTROLS: http://pokemonessentials.wikia.com/wiki/Tutorial:Set_the_Controls_Screen
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String commands =  "W:UP " + "S:DOWN " + "A:LEFT " + "D:RIGHT " + "X:INTERACT ";
		System.out.println(commands);
	}
	
	//method to display Player's 6 captured Pokemon
	public void displayPokemon() {
		System.out.println("AVAILABLE POKEMON: ");
		for (int i = 0; i < _Pokemon.size(); i++ ) {
			Pokemon temp = _Pokemon.get(i);
			System.out.println(i + ": " + temp.getName());
			System.out.println("HP: " + temp.getHP());
		}
	}
	
	public static void clearDisplay() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}  
	
	//~~~~~~~~~~EXECUTE-CONTROLS~~~~~~~~~~~~~~~
	
	//executes command
	public void executeControl( String command ) {
		
		//NON-BATTLE COMMANDS
		
		if ( battleMode == false ) {
			if ( command.toLowerCase().equals("w") ) { 
				if( Player.getY() != 0 ) {
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //resets old location
					Map.get( Player.getY(), Player.getX() ).setImage();
					Player.setY(Player.getY() - 1);
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //moves to new location
					Map.get( Player.getY(), Player.getX() ).setImage();		    
				}
				//user.setX, user.setY, change map's player coordinates
				if( (int)(Math.random()*15) == 1 ) {
					battleMode = true;
				}
			}
			if ( command.toLowerCase().equals("a") ) {
				if( Player.getX() != 0 ) {
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //resets old location
					Map.get( Player.getY(), Player.getX() ).setImage();
					Player.setX(Player.getX() - 1);
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //moves to new location
					Map.get( Player.getY(), Player.getX() ).setImage();		    
				}
				//user.setX, user.setY, change map's player coordinates
				if( (int)(Math.random()*15) == 1 ) {
					battleMode = true;
				}
			}
			if ( command.toLowerCase().equals("s") ) {
				if( Player.getY() != 19 ) {
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //resets old location
					Map.get( Player.getY(), Player.getX() ).setImage();
					Player.setY(Player.getY() + 1);
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //moves to new location
					Map.get( Player.getY(), Player.getX() ).setImage();		    
				}
				//user.setX, user.setY, change map's player coordinates
				if( (int)(Math.random()*15) == 1 ) {
					battleMode = true;
				}
			}
			if ( command.toLowerCase().equals("d") ) {
				if( Player.getX() != 19 ) {
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //resets old location
					Map.get( Player.getY(), Player.getX() ).setImage();
					Player.setX(Player.getX() + 1);
					Map.get( Player.getY(), Player.getX() ).setIsPlayerHere(); //moves to new location
					Map.get( Player.getY(), Player.getX() ).setImage();		    
				}
				//user.setX, user.setY, change map's player coordinates
				if( (int)(Math.random()*15) == 1 ) {
					battleMode = true;
				}
			}
			if ( command.toLowerCase().equals("x") ) {
				//check block in front using player.getDirection()
				//we will have: trees, rocks, walls, enemy trainers
			}
		}//ends NON-BATTLE COMMANDS
		
		//BATTLE COMMANDS
		
		else if ( battleMode == true ) {
		
			// *** FOR ALL EXCEPT RUN, HAVE A "B: Back" IN THE CORNER OF DISPLAY TO ALLOW USER TO GO BACK ***
			
			if ( command.toLowerCase().equals("1") ) { //FIGHT
				//DISPLAY SELECTED POKEMON'S MOVES
				String temp = promptControl(); //prompt user to choose move (1-4)
				String move = Integer.parseInt( temp ); //converts string input to int
				//make selected pokemon from _pokemon use method attack on enemy pokemon
			}
			if ( command.toLowerCase().equals("2") ) { //BAG
				//DISPLAY BAG: Pkballs, potions, battle items (NO KEY ITEMS)
				//prompt user for another input to choose what to do
			}
			if ( command.toLowerCase().equals("3") ) { //POKEMON
				displayPokemon(); //displays pkmn 1-6 with name + health
				String temp = promptControl(); //prompt user to pick which to choose (1-6)
				selectedPokemon = Integer.parseInt( temp ); // converts the string to the int
				//can also type "BACK" to go back
			}
			if ( command.toLowerCase().equals("4") ) { //RUN
				if (enemyPokemon.getWild == false) { System.out.println("You cannot run from a trainer battle..."; }
				else if (Math.random() * 100 < 50) {
				//if wild pkmn, chance of running = http://bulbapedia.bulbagarden.net/wiki/Escape#Success_conditions
					System.out.println( "You have successfully escaped!" );
					waitMS(5000);
					battleMode = false;
				}
				else {
					System.out.println( "You have failed to run away..." );
					waitMS(5000);
					opponentTurn = true;
				}
			}
		}//ends BATTLE COMMANDS
		
	}
	
	public void opponentBattle() {
		//implementation for opponent Pokemon to battle
	}
	
	//~~~~~~~~~~~~~~PLAYING POKEMON!!!~~~~~~~~~~~~~~~
	
	public void play() {
		//startup prompts; only prompts user once
		startupMsg();
		String gender = promptGender();
		String name = promptName();
		
		//instantiation of classes
		Player user = new Player(gender, name);
		Pokemon captured; //create a new pkmn() whenever a pokemon is captured, and set it equal to this
		//then add captured pokemon to list _Pokemon
		Map userMap = new Map();
		Battle battle = new Battle(); // a temporary solution
		
		//prompts for starter Pokemon, and creates one accordingly
		int starter = promptStarter();
		if (starter == 1) { captured = new Bulbasaur(); }
		else if (starter == 2) { captured = new Charmander(); }
		else if (starter == 3) { captured = new Squirtle(); }
		_Pokemon.add( captured ); //adds starter to list _Pokemon
		
		//more instantiations
		selectedPokemon = 0;
		Pokemon currentPokemon = _Pokemon[selectedPokemon];
		Pokemon enemyPokemon;
		//WE WILL USE THESE INSTANTIATIONS DURING A BATTLE
		
		//RUNS GAME:
		while ( user.getQuest() != 20 ) {
			
			if ( battleMode == false ) { //not in battle -> show map + map commands
				System.out.println( userMap );
				displayCommands();
			}
			else if ( battleMode == true ) { displayBattle(); } //in battle -> show battle
			System.out.println(captured.getName);
			
			String control = promptControl(); //prompts user for a command
			executeControl( control );
			/*
			if (battleMode == false) { //after a player walks
				battleMode = battleStart?(); //checks if player is on grass & chance to start battle
				enemyPokemon = new Rattata();
			}
			//made it like this so that when a battle starts, enemy gets instantiated*/
			
			
			//if ( opponentTurn == true) { //opponentBattle(); }
			
		}
	}
	
	public static void main (String[] args) {
		Game POKEMON = new Game();
		POKEMON.play();
	}
	
}
