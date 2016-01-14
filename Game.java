//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
    private boolean battleMode = false;
    private final String[] commandsWalk = {"w","a","s","d","x"}; //used to check valid commands outside battle
    private final String[] commandsBattle = {"1","2","3","4"}; //used to check valid commands in battle
    //LIST OF CONTROLS: http://pokemonessentials.wikia.com/wiki/Controls
    //SETTING POKEMON CONTROLS: http://pokemonessentials.wikia.com/wiki/Tutorial:Set_the_Controls_Screen
	
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
	
    //method to display map
    public void displayMap() {
	//implementation to display map and player
    }
	
    //method to display Pokemon battle
    public void displayBattle() {
	//implementation to display battle
    }
	
    //method to display available commands depending on in battle or not
    public void displayCommands() {
	System.out.println("~~~~~~~~~~~~~~~~~~~~");
	String commands = "";
	if (battleMode == false) {
	    commands = "W:UP " + "S:DOWN " + "A:LEFT " + "D:RIGHT " + "X:INTERACT ";
	}
	else if (battleMode == true) {
	    commands = "1: FIGHT " + "2: BAG " + "3: POKEMON " + "4: RUN ";
	}
	System.out.println(commands);
    }
	
    //method to "clear" terminal
    public static void clearDisplay() {
	for( int n = 0; n < 50; n++ ) {
	    System.out.println("");
	}
    }
	
    //~~~~~~~~~~EXECUTE-CONTROLS~~~~~~~~~~~~~~~
	
    //checks if command is valid
    public boolean checkControl( String control ) {
	if (battleMode == false) {
	    for ( int i = 0; i < commandsWalk.length; i++ ) {
		if ( control.equals( commandsWalk[i] ) ) { return true; }
	    }
	}
	else if (battleMode == true) {
	    for ( int i = 0; i < commandsBattle.length; i++ ) {
		if ( control.equals( commandsBattle[i] ) ) { return true; }
	    }
	}
	return false;
    }
	
    //executes command
    public void executeControl( String command ) {

	//Valid commands in a battle
	if ( battleMode == true ) {
	    if ( command.toLowerCase().equals("1") ) { //FIGHT
		//fight
		//can also type "BACK" to go back
	    }
	    if ( command.toLowerCase().equals("2") ) { //BAG
		//displayBag();
		//prompt user for another input to choose what to do
		//can also type "BACK" to go back
	    }
	    if ( command.toLowerCase().equals("3") ) { //POKEMON
		//displayPokemon(); displays pkmn 1-6 with name + health
		//prompt user to pick which to choose (1-6)
		//can also type "BACK" to go back
	    }
	    if ( command.toLowerCase().equals("4") ) { //RUN
		//checks if battle is a Trainer battle
		battleMode = false;
		System.out.println( "You have successfully escaped" );
		//if not, chance of running = http://bulbapedia.bulbagarden.net/wiki/Escape#Success_conditions
	    }
	}//ends battlemodecommands
	    
	//Valid commands out of battle
	else if ( battleMode == false ) {
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
	}//ends nonbattlemodecommands		
    }
	
    public void opponentBattle() {
	//implementation for opponent Pokemon to battle
    }
	
    //~~~~~~~~~~~~~~PLAYING POKEMON!!!~~~~~~~~~~~~~~~
	
    public void play() {
	//startup prompts; only prompts user once
	Map userMap = new Map();
	startupMsg();
	String gender = promptGender();
	String name = promptName();
	Player user = new Player(gender, name);
	Battle battle = new Battle(); // a temporary solution
		
	//prompts for starter Pokemon, and creates one accordingly
	int starter = promptStarter();
	if (starter == 1) { Pokemon baws = new Bulbasaur(); }
	else if (starter == 2) { Pokemon baws = new Charmander(); }
	else if (starter == 3) { Pokemon baws = new Squirtle(); }
		
	//RUNS GAME:
	while ( user.getQuest() != 20 ) {
	    //clearDisplay(); //comment out when debugging
	    //CHANGE CLEARDISPLAY TO WHATEVER IS NEEDED TO FIT MAP; WE DON'T NEED LIKE 50 EMPTY LINES
	    if ( battleMode == false ) { System.out.println( userMap ); }
	    else if ( battleMode == true ) { System.out.println( battle ); }
	    displayCommands();
			
	    boolean validCommand = false;
	    String control = "";
	    while (validCommand == false) {
		//prompts user for a command
		control = promptControl();
		//checks for validity of command
		validCommand = checkControl( control );
		//if invalid, prompts again before doing anything else
		if (validCommand == false) { System.out.println("Invalid control.\n"); }
	    }
			
	    executeControl( control );
	    if ( battleMode == true ) {
		//opponentBattle(); //opposing Pokemon will always try to fight with 1 of its 4** moves
	    }
	}
    }
	
    public static void main (String[] args) {
	Game POKEMON = new Game();
	POKEMON.play();
    }
	
}


