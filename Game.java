//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import java.util.ArrayList;
import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
    private ArrayList<Pokemon> _Pokemon = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> _PokemonEnemy = new ArrayList<Pokemon>();
    private int selectedPokemon, capturedPokemon, battleScreen;
    private Pokemon captured, currentPokemon, enemyPokemon;
    private Battle battle = new Battle();
    private Inventory bag = new Inventory();
    private boolean battleMode = false;
    private boolean opponentTurn = false;
	
	//~~~~~~~~~~~~~~~MISC.~~~~~~~~~~~~~~~~~~~~~~~
	
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
		gen = Keyboard.readString();
		return gen;
	}
	
    //method to prompt name of player
    public String promptName() {
		String name = "";
		System.out.println("All right. Tell me, what is your name? (1-8 characters)");
		name = Keyboard.readString();
		//restricts name to 8 characters; can change if necessary
		if (name.length() > 8) {
			name = name.substring(0,8);
			System.out.println("Name too long. Setting name to " + name + ".\n");
		}
		return name;
	}
	
    //method to prompt player to pick his/her starter Pokemon
    public int promptStarter() {
		String pkmn = "";
		int n = 0;
		System.out.println("In this world of Pokemon, you'll need a partner Pokemon to be with you.");
		System.out.println("Tell me, which Pokemon would you like to be your partner?");
		System.out.println("1. Bulbasaur\t2. Charmander\t3. Squirtle");
		pkmn = Keyboard.readString();
		try { n = Integer.parseInt(pkmn); }
		catch (Exception e) { n = 0; }
		return n;
	}
	
    //method to prompt user for a command
    public String promptControl() {
		String ctrl = "";
		System.out.print("Enter a control: ");
		ctrl = Keyboard.readString();
		ctrl = ctrl.toLowerCase();
		return ctrl;
	}
	
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DISPLAYS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~NON-BATTLE-DISPLAYS~~~~~~~~~~~~~~
	
	public void displayCommands() {
		System.out.println("============================================================");
		String commands = "W:UP " + "S:DOWN " + "A:LEFT " + "D:RIGHT " + "X:INTERACT ";
	}
	
	//~~~~~~~~~~~~~~~BATTLE-DISPLAYS~~~~~~~~~~~~~~~~
	
	public void displayBattle() {
		
		displayBattlefield(); //This method will show name, hp, level, and exp of BOTH pokemon in battle (exp only for user)
		//I added battle.reset() into displayBattlefield() so every time it runs it'll reset the battle, so it does the same thing
		
		//Main Menu
		if ( battleScreen == 0 ) { displayBattleMenu(); } 
		//List of Moves (Fight)
		if ( battleScreen == 1) { displayFight(); }
		//List of Bag
		if ( battleScreen == 2) { displayBag(); }
		//List of Pokemon (Pokemon)
		if ( battleScreen == 3) { displayPokemon(); }
		
		//Inside inventory
		//List of Pokeballs
		if ( battleScreen == 4) { displayBag1(); }
		//List of Potions
		if ( battleScreen == 5) { displayBag2(); }
		//List of Battle Items
		if ( battleScreen == 6) { displayBag3(); }
		
		//displaySystemMsg(); //This method will have some message depending on what the user did before;
		//This might conflict with sequence of methods so might not implement this at all
		
	}
	
	public void displayBattlefield() {
		//displays user's pkmn + enemy pkmn on top (half the screen total ?)
		Battle.reset();
		Battle.set( 0, 0, "=============================================================" );
		Battle.set( 1, 0, " Lv." + enemyPokemon.getLevel() + "     " + enemyPokemon.getName() + "(" + enemyPokemon.getType() + ")" );
		Battle.set( 2, 0, displayHP( enemyPokemon ) + " (" + enemyPokemon.getHP() + "/" + enemyPokemon.getMaxHP() + ")" );
		
		Battle.set( 4, 0, "-------------------------------------------------------------" );
		Battle.set( 5, 0, " Lv." + currentPokemon.getLevel() + "     " + currentPokemon.getName() + "(" + currentPokemon.getType() + ")" );
		Battle.set( 6, 0, displayHP( currentPokemon ) + " (" + currentPokemon.getHP() + "/" + currentPokemon.getMaxHP() + ")" );
		Battle.set( 7, 0, displayEXP( currentPokemon ) + " (" + currentPokemon.getEXP() + "/" + currentPokemon.getLevelEXP() + ")" );
		Battle.set( 8, 0, "=============================================================" );
	}
	
	public void displayBattleMenu() {
	    Battle.set( 10, 0, center("WHAT WILL " + Player.getName() + " DO?", 61) );
		Battle.set( 12, 0, "                -----------       -----------" );
		Battle.set( 13, 0, "                | 1:FIGHT |       |  2:BAG  |" );
		Battle.set( 14, 0, "                -----------       -----------" );
		Battle.set( 16, 0, "                -----------       -----------" );
		Battle.set( 17, 0, "                |3:POKEMON|       |  4:RUN  |" );
		Battle.set( 18, 0, "                -----------       -----------" );
		System.out.println( battle );
	}
	
	public void displayFight() {
	    Battle.set( 9, 0, center("WHAT WILL " + currentPokemon.getName() + " DO?", 59).substring(0,54) + "B: BACK" );
	    Battle.set( 11, 0, "      --------------------       --------------------" );
	    Battle.set( 12, 0, "      |" + indent(" (1) " + currentPokemon.getMovesName(0), 18) + "|" );
	    Battle.set( 13, 0, "      |" + indent(" [" + currentPokemon.getType() + "] PP " + currentPokemon.getCurrentPP(0) + "/" + currentPokemon.getMaxPP(0), 18) + "|" );
	    Battle.set( 14, 0, "      --------------------       --------------------" );
	    Battle.set( 16, 0, "      --------------------       --------------------" ); 
	    Battle.set( 17, 0, "      |" + indent(" (3) " + currentPokemon.getMovesName(2), 18) + "|" );
	    Battle.set( 18, 0, "      |" + indent(" [" + currentPokemon.getType() + "] PP " + currentPokemon.getCurrentPP(2) + "/" + currentPokemon.getMaxPP(2), 18) + "|" );
	    Battle.set( 19, 0, "      --------------------       --------------------" );
	    Battle.set( 12, 1, "       |" + indent(" (2) " + currentPokemon.getMovesName(1), 18) + "|" );
	    Battle.set( 13, 1, "       |" + indent(" [" + currentPokemon.getType() + "] PP " + currentPokemon.getCurrentPP(1) + "/" + currentPokemon.getMaxPP(1), 18) + "|" );
	    Battle.set( 17, 1, "       |" + indent(" (4) " + currentPokemon.getMovesName(3), 18) + "|" );
	    Battle.set( 18, 1, "       |" + indent(" [" + currentPokemon.getType() + "] PP " + currentPokemon.getCurrentPP(3) + "/" + currentPokemon.getMaxPP(3), 18) + "|" );
	    System.out.println( battle );	    
	}
	
	public void displayBag() {
	    Battle.set( 9, 0, "                       CHOOSE A BAG                   B: BACK" );
	    Battle.set( 11, 0, "                     ----------------" );
	    Battle.set( 12, 0, "                     |  1:POKEBALLS |" );
	    Battle.set( 13, 0, "                     ----------------" );
	    Battle.set( 14, 0, "                     ----------------" );
	    Battle.set( 15, 0, "                     |  2:POTIONS   |" );
	    Battle.set( 16, 0, "                     ----------------" );
	    Battle.set( 17, 0, "                     ----------------" );
	    Battle.set( 18, 0, "                     |3:BATTLE ITEMS|" );
	    Battle.set( 19, 0, "                     ----------------" );
	    System.out.println( battle );
	}
	
	public void displayPokemon() {
		Battle.set( 9, 0,  "                      AVAILABLE POKEMON:              B: BACK" );
		Battle.set( 10, 0, "------------------------------ ------------------------------" );
		Battle.set( 11, 0, "|" + indent(" (1) Lv." + _Pokemon.get(0).getLevel() + " " + _Pokemon.get(0).getName() + "(" + _Pokemon.get(0).getType() + ")", 28) + "|" );
		Battle.set( 12, 0, "|" + indent(displayHP( _Pokemon.get(0) ), 28) + "|" );
		Battle.set( 13, 0, "------------------------------ ------------------------------" );
		Battle.set( 14, 0, "|" + indent(" (2) Lv." + _Pokemon.get(1).getLevel() + " " + _Pokemon.get(1).getName() + "(" + _Pokemon.get(1).getType() + ")", 28) + "|" );
		Battle.set( 15, 0, "|"+ indent(displayHP( _Pokemon.get(1) ), 28) + "|" );
		Battle.set( 16, 0, "------------------------------ ------------------------------" );
		Battle.set( 17, 0, "|" + indent(" (3) Lv." + _Pokemon.get(2).getLevel() + " " + _Pokemon.get(2).getName() + "(" + _Pokemon.get(2).getType() + ")", 28) + "|" );
		Battle.set( 18, 0, "|" + indent(displayHP( _Pokemon.get(2) ), 28) + "|" );
		Battle.set( 19, 0, "------------------------------ ------------------------------" );
		// second column
		Battle.set( 11, 1, " |" + indent(" (4) Lv." + _Pokemon.get(3).getLevel() + " " + _Pokemon.get(3).getName() + "(" + _Pokemon.get(3).getType() + ")", 28) + "|" );
		Battle.set( 12, 1, " |" + indent(displayHP( _Pokemon.get(3) ), 28) + "|" );
		Battle.set( 14, 1, " |" + indent(" (5) Lv." + _Pokemon.get(4).getLevel() + " " + _Pokemon.get(4).getName() + "(" + _Pokemon.get(4).getType() + ")", 28) + "|" );
		Battle.set( 15, 1, " |" + indent(displayHP( _Pokemon.get(4) ), 28) + "|" );
		Battle.set( 17, 1, " |" + indent(" (6) Lv." + _Pokemon.get(5).getLevel() + " " + _Pokemon.get(5).getName() + "(" + _Pokemon.get(5).getType() + ")", 28) + "|" );
		Battle.set( 18, 1, " |" + indent(displayHP( _Pokemon.get(5) ), 28) + "|" );
		System.out.println( battle );
	}
	
	//displays user's Pokeballs; 1. Poke Ball 2. Great Ball 3. Ultra Ball 4. Master Ball
	public void displayBag1() {
	    Battle.set( 9, 0, "                        POKEBALLS                     B: BACK" );
	    Battle.set( 11, 0,"                  ----------------------" );
	    Battle.set( 12, 0,"                  |" + indent(" 1: Poke Ball   x" + bag.getPokeball(0), 20) + "|" );
	    Battle.set( 13, 0,"                  ----------------------" );
	    Battle.set( 14, 0,"                  |" + indent(" 2: Great Ball  x" + bag.getPokeball(1), 20) + "|" );
	    Battle.set( 15, 0,"                  ----------------------" );
	    Battle.set( 16, 0,"                  |" + indent(" 3: Ultra Ball  x" + bag.getPokeball(2), 20) + "|" );
	    Battle.set( 17, 0,"                  ----------------------" );
	    Battle.set( 18, 0,"                  |" + indent(" 4: Master Ball x" + bag.getPokeball(3), 20) + "|" );
	    Battle.set( 19, 0,"                  ----------------------" );
	    System.out.println( battle );
	}
	
	//displays user's Potions; 1. Potion 2. Super Potion 3. Hyper Potion 4. Full Restore 5. Elixir 6. Max Elixir; Elixirs are for PP
	public void displayBag2() {
	    Battle.set( 10, 0, "                         POTIONS                      B: BACK" );
	    Battle.set( 12, 0, "   ------------------------- -------------------------" );
	    Battle.set( 13, 0, "   |" + indent(" 1: Potion         x" + bag.getPotion(0), 23) + "|" );
	    Battle.set( 14, 0, "   ------------------------- -------------------------" );
	    Battle.set( 15, 0, "   |" + indent(" 2: Super Potion   x" + bag.getPotion(1), 23) + "|" );	    
	    Battle.set( 16, 0, "   ------------------------- -------------------------" );
	    Battle.set( 17, 0, "   |" + indent(" 3: Hyper Potion   x" + bag.getPotion(2), 23) + "|" );
	    Battle.set( 18, 0, "   ------------------------- -------------------------" );
	    Battle.set( 13, 1, " |" + indent(" 4: Full Restore   x" + bag.getPotion(3), 23) + "|" );
	    Battle.set( 15, 1, " |" + indent(" 5: Elixir Potion  x" + bag.getPotion(4), 23) + "|" );
	    Battle.set( 17, 1, " |" + indent(" 6: Max Elixir     x" + bag.getPotion(5), 23) + "|" );
	    System.out.println( battle );
	}
	
	//displays user's Battle Items; 1. Protein 2. Iron
	public void displayBag3() {
	    Battle.set( 11, 0, "                       BATTLE ITEMS                   B: BACK" );
	    Battle.set( 13, 0, "                  ----------------------" );
	    Battle.set( 14, 0, "                  |" + indent( " 1: Protein    x" + bag.getBattleItem(0), 20 ) + "|" );
	    Battle.set( 15, 0, "                  ----------------------" );
	    Battle.set( 16, 0, "                  |" + indent( " 2: Iron       x" + bag.getBattleItem(0), 20 ) + "|" );
	    Battle.set( 17, 0, "                  ----------------------" );	    
	    System.out.println( battle );
	}
	
	//method to turn HP into a bar
	public String displayHP( Pokemon p ) {
		double eachBar = ( ( p.getMaxHP() ) / 20.0 ); // this is how much hp each bar is worth
		int numBar = (int)( ( p.getHP() ) / eachBar); // number of bars displayed
		String bar = " HP[";
		for( int n = 0; n < numBar; n++ ) {
			bar += "|";
		}
		for( int n = 0; n < (20 - numBar); n++ ) {
			bar += " ";
		}
		bar += "]";
		return bar;
	}
	
	//method to turn EXP into a bar
	public String displayEXP( Pokemon p ) {
		double eachBar = ( ( p.getLevelEXP() ) / 20.0 ); // this is how much exp each bar is worth
		int numBar = (int)( ( p.getEXP() ) / eachBar ); // number of bars displayed
		String bar = " EXP[";
		for( int n = 0; n < numBar; n++ ) {
			bar += "|";
		}
		for( int n = 0; n < (20-numBar); n++ ) {
			bar += " ";
		}
		bar += "]";
		return bar;
	}
	
	// helper method to equally space out the first column of "displayPokemon()"
    public String indent( String s, int x ) {
		String temp = new String( s ); //copy string
		int numChar = 0;
		while( temp.length() > 0 ) {
			temp = temp.substring(1);
			numChar++;
		}
		for( int n = 0; n < (x - numChar); n++ ) {
			s += " ";
		}	        
		return s;
	}
    public String center( String s, int x ) {
		String temp = new String( s ); //copy string
		int numChar = 0;
		while( temp.length() > 0 ) {
			temp = temp.substring(1);
			numChar++;
		}
		for( int n = 0; n < (x - numChar)/2; n++ ) {
		    s = " " + s;
		    s += " ";
		}
		return s;
    }
	
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~EXECUTE-CONTROLS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
    //Executes Non-Battle Commands
	
    public void executeControl( String command ) {
	int y = Player.getY();
	int x = Player.getX();
	Tile from = Map.get( y, x ); // a var for player's original location
	if ( command.equals("w") ) {
	    Tile to = Map.get( y-1, x );
	    Player.setDirection( "UP" );
	    if( y!=0 && !to.isObstacle() ) {
		from.reset();
		to.movePlayer();
		Player.setY(y - 1);		
	    }
	    if( to.getType().equals("PKCenter") ) { //PKCenter heals every captured pokemon
		for( int i = 0; i < capturedPokemon; i++ ) {
		    _Pokemon.get(i).restoreHP( 999 );
		}
	    }
	    if( to.getType().equals("ForwardPortal") ) {
		Player.setMapNum( Player.getMapNum()+1 );
	    }
	    if( to.getType().equals("BackPortal") ) {
		Player.setMapNum( Player.getMapNum()-1 );
	    }	    
	    //user.setX, user.setY, change map's player coordinates
	    if( to.getType().equals("Grass") ) {
		if( (int)(Math.random()*15) == 1 ) {
		    battleStart();		    
		}
	    }	   
	}
		
	if ( command.equals("a") ) {
	    Tile to = Map.get( y, x-1 );
	    Player.setDirection( "LEFT" );
	    if( x!=0 && !to.isObstacle() ) {
		from.reset();
		to.movePlayer();
		Player.setX(x - 1);
	    }
	    if( to.getType().equals("PKCenter") ) {
		for( int i = 0; i < capturedPokemon; i++ ) {
		    _Pokemon.get(i).restoreHP( 999 );
		}
	    }
	    if( to.getType().equals("ForwardPortal") ) {
		Player.setMapNum( Player.getMapNum()+1 );
	    }
	    if( to.getType().equals("BackPortal") ) {
		Player.setMapNum( Player.getMapNum()-1 );
	    }	    
	    //user.setX, user.setY, change map's player coordinates
	    if( to.getType().equals("Grass") ) {
		if( (int)(Math.random()*15) == 1 ) {
		    battleStart();		    
		}
	    }	
	}
		
	if ( command.equals("s") ) {
	    Tile to = Map.get( y+1, x );
	    Player.setDirection( "DOWN" );	    
	    if( y!=19 && !to.isObstacle() ) {
		from.reset();
		to.movePlayer();
		Player.setY(y + 1);
	    }
	    if( to.getType().equals("PKCenter") ) {
		for( int i = 0; i < capturedPokemon; i++ ) {
		    _Pokemon.get(i).restoreHP( 999 );
		}
	    }
	    if( to.getType().equals("ForwardPortal") ) {
		Player.setMapNum( Player.getMapNum()+1 );
	    }
	    if( to.getType().equals("BackPortal") ) {
		Player.setMapNum( Player.getMapNum()-1 );
	    }	    
	    //user.setX, user.setY, change map's player coordinates
	    if( to.getType().equals("Grass") ) {
		if( (int)(Math.random()*15) == 1 ) {
		    battleStart();		    
		}
	    }	
	}
		
	if ( command.equals("d") ) {
	    Tile to = Map.get( y, x+1 );
	    Player.setDirection( "RIGHT" );	    
	    if( x!=19 && !to.isObstacle() ) {
		from.reset();
		to.movePlayer();
		Player.setX(x + 1);
	    }
	    if( to.getType().equals("PKCenter") ) {
		for( int i = 0; i < capturedPokemon; i++ ) {
		    _Pokemon.get(i).restoreHP( 999 );
		}
	    }
	    if( to.getType().equals("ForwardPortal") ) {
		Player.setMapNum( Player.getMapNum()+1 );
	    }
	    if( to.getType().equals("BackPortal") ) {
		Player.setMapNum( Player.getMapNum()-1 );
	    }	    
	    //user.setX, user.setY, change map's player coordinates
	    if( to.getType().equals("Grass") ) {
		if( (int)(Math.random()*15) == 1 ) {
		    battleStart();		    
		}
	    }	
	}
		
	if ( command.equals("x") ) {
	    //check block in front using player.getDirection()
	    //we will have: trees, rocks, walls, enemy trainers
	}
		
    }//ends NON-BATTLE COMMANDS
	
	//Executes Battle Commands
	
	public void executeBattleControl ( String command ) {
		//LIST OF CONTROLS: http://pokemonessentials.wikia.com/wiki/Controls
		//SETTING POKEMON CONTROLS: http://pokemonessentials.wikia.com/wiki/Tutorial:Set_the_Controls_Screen
		
		//Battle Menu
		if ( battleScreen == 0 ) {
			if ( command.equals("1") ) { battleScreen = 1; } //Fight
			if ( command.equals("2") ) { battleScreen = 2; } //Bag
			if ( command.equals("3") ) { battleScreen = 3; } //Pokemon
			if ( command.equals("4") ) { //Run
				if ( enemyPokemon.getWild() == false ) { System.out.println("You cannot run from a trainer battle..."); }
				else if (Math.random() * 100 < 50) {
					//if wild pkmn, chance of running = http://bulbapedia.bulbagarden.net/wiki/Escape#Success_conditions
					System.out.println( "You have successfully escaped!" );
					waitMS(1000);
					battleMode = false;
				}
				else {
					System.out.println( "You have failed to run away..." );
					waitMS(1000);
					opponentTurn = true;
				}
			}
		}
		
		//Fight
		else if ( battleScreen == 1 ) {
			if ( command.equals("1") ) { //Attacks with first move
				currentPokemon.attack(enemyPokemon, 1);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("2") ) { //Attacks with second move
				currentPokemon.attack(enemyPokemon, 2);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("3") && currentPokemon.getMovesNum() >= 3 ) { //Attacks with third move
				currentPokemon.attack(enemyPokemon, 3);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("4") && currentPokemon.getMovesNum() == 4 ) { //Attacks with fourth move
				currentPokemon.attack(enemyPokemon, 4);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("b") ) { battleScreen = 0; } //Goes back to previous screen
		}
		
		//Bag
		else if ( battleScreen == 2 ) {
			if ( command.equals("1") ) { battleScreen = 4; } //Pokeballs
			if ( command.equals("2") ) { battleScreen = 5; } //Potions
			if ( command.equals("3") ) { battleScreen = 6; } //Battle Items
			if ( command.equals("b") ) { battleScreen = 0; } //Goes back to previous screen
		}
		
		//Pokemon
		else if ( battleScreen == 3 ) {
			try {
				selectedPokemon = Integer.parseInt( command );
				selectedPokemon = selectedPokemon - 1;
			}
			catch (Exception e) { battleScreen = 3; }
			if ( selectedPokemon < capturedPokemon && !( _Pokemon.get(selectedPokemon).equals(currentPokemon) ) ) {
				currentPokemon = _Pokemon.get( selectedPokemon ); //Swaps out Pokemon
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("b") ) { battleScreen = 0; } //Goes back to previous screen
		}
		
		//Bag -- Pokeballs
		//Using: http://bulbapedia.bulbagarden.net/wiki/Catch_rate#Modified_catch_rate_3
		else if ( battleScreen == 4 ) {
			double RNG = Math.random() + 1;
			if ( command.equals("1") && bag.getPokeball(0) != 0 && _Pokemon.size() < 6 ) { //Throws Poke Ball
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 1) / (double)(3 * enemyPokemon.getMaxHP()) );
				bag.lowerAmount(0, 0);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
				if ( catchRate >= 0.5  ) {
					captured = enemyPokemon;
					_Pokemon.add( captured );
					opponentTurn = false;
					battleMode = false;
					return;
				}
			}
			if ( command.equals("2") && bag.getPokeball(1) != 0 && _Pokemon.size() < 6 ) { //Throws Great Ball
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 1.5) / (double)(3 * enemyPokemon.getMaxHP()) );
				bag.lowerAmount(0, 1);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
				if ( catchRate >= 0.75  ) {
					captured = enemyPokemon;
					_Pokemon.add( captured );
					opponentTurn = false;
					battleMode = false;
					return;
				}
			}
			if ( command.equals("3") && bag.getPokeball(2) != 0 && _Pokemon.size() < 6 ) { //Throws Ultra Ball
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 2) / (double)(3 * enemyPokemon.getMaxHP()) );
				bag.lowerAmount(0, 2);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
				if ( catchRate >= 1.0  ) {
					captured = enemyPokemon;
					_Pokemon.add( captured );
					opponentTurn = false;
					battleMode = false;
					return;
				}
			}
			if ( command.equals("4") && bag.getPokeball(3) != 0 && _Pokemon.size() < 6 ) { //Throws Master Ball
				double catchRate = 256;
				bag.lowerAmount(0, 3);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
				if ( catchRate >= 1.0  ) {
					captured = enemyPokemon;
					_Pokemon.add( captured );
					opponentTurn = false;
					battleMode = false;
					return;
				}
			}
			if ( command.equals("b") ) { battleScreen = 2; } //Goes back to previous screen
		}//ends Bag -- Pokeballs
		
		//Bag -- Potions
		else if ( battleScreen == 5 ) {
			if ( command.equals("1") && bag.getPotion(0) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Potion
				currentPokemon.restoreHP(20);
				bag.lowerAmount(1, 0);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("2") && bag.getPotion(1) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Super Potion
				currentPokemon.restoreHP(50);
				bag.lowerAmount(1, 1);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("3") && bag.getPotion(2) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Hyper Potion
				currentPokemon.restoreHP(200);
				bag.lowerAmount(1, 2);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("4") && bag.getPotion(3) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Max Potion
				currentPokemon.restoreHP(999);
				bag.lowerAmount(1, 3);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("5") && bag.getPotion(4) != 0 && currentPokemon.allMaxPP() ) { //Uses Elixir
				currentPokemon.restorePP(5);
				bag.lowerAmount(1, 4);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("6") && bag.getPotion(5) != 0 && currentPokemon.allMaxPP() ) { //Uses Max Elixir
				currentPokemon.restorePP(999);
				bag.lowerAmount(1, 5);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("b") ) { battleScreen = 2;
			} //Goes back to previous screen
		}//ends Bag -- Potions
		
		//Bag -- Battle Items
		else if ( battleScreen == 6 ) {
			if ( command.equals("1") && bag.getBattleItem(0) != 0 ) { //Uses Protein
				currentPokemon.setAttack( currentPokemon.getAttack() + 10 );
				bag.lowerAmount(2, 0);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("2") && bag.getBattleItem(1) != 0 ) { //Uses Iron
				currentPokemon.setDefense( currentPokemon.getDefense() + 10 );
				bag.lowerAmount(2, 1);
				battleScreen = 0; //Goes back to default menu
				opponentTurn = true;
			}
			if ( command.equals("b") ) { battleScreen = 2; } //Goes back to previous screen
		}//ends Bag -- Battle Items
		
	}//ends BATTLE COMMANDS
	
	
	public void opponentBattle() {
		//further changes later
		enemyPokemon.attack( currentPokemon, 0 );
		opponentTurn = false;
	}
	
	//Capturing pokemon
	public void capturePokemon( Pokemon p ) {
		capturedPokemon = capturedPokemon + 1;
		_Pokemon.set( capturedPokemon - 1, p );
	}
	
	//Starting a Pokemon Battle
	public void battleStart() {
		battleMode = true;
		enemyPokemon = new Rattata();
		enemyPokemon.setWild(true);
		//later implement diff wild pkmn on random chance
		selectedPokemon = 0;
		currentPokemon = _Pokemon.get(selectedPokemon);
	}
	
	//~~~~~~~~~~~~~~PLAYING POKEMON!!!~~~~~~~~~~~~~~~
	
	public void play() {
		//startup prompts; only prompts user once
		startupMsg();
		String gender = "";
		while ( !(gender.equals("boy")) && !(gender.equals("girl")) ) {
			gender = promptGender();
		}
		String name = promptName();
		
		//instantiation of classes
		Player user = new Player(gender, name);
		Map userMap = new Map(Player.getMapNum());
		
		//sets up _Pokemon ArrayList
		for( int i = 0; i < 6; i++ ) {
			_Pokemon.add( new Default() );
		}
		
		//prompts for starter Pokemon, and captures one accordingly
		capturedPokemon = 0;
		int starter = 0;
		while (starter != 1 && starter != 2 && starter != 3) {
			starter = promptStarter();
		}
		
		if (starter == 1) { captured = new Bulbasaur(); }
		else if (starter == 2) { captured = new Charmander(); }
		else if (starter == 3) { captured = new Squirtle(); }
		capturePokemon(captured);
		
		//RUNS GAME:
		while ( user.getQuest() != 20 ) {
			
			//Display Map/Battlefield
			if ( battleMode == false ) { //not in battle -> show map + map commands
				System.out.println( userMap );
				displayCommands();
			}
			else if ( battleMode == true ) { displayBattle(); } //in battle -> show battle
			
			//Prompts Control
			String control = promptControl();
			if ( battleMode == false ) { executeControl( control ); }
			else if ( battleMode == true ) { executeBattleControl( control ); }
			System.out.println("battlemode: " + battleMode);
			
			//if ( battleMode == true ) { displayBattle(); } //displays battle msg after user does something; implementing later
			
			/*//Checks if Enemy Pokemon has been defeated
				if ( battleMode == true && enemyPokemon.fainted() ) {
				currentPokemon.normalize();
				battleMode = false;
			}*/
			
			//if ( battleMode == true && opponentTurn == true ) { opponentBattle(); }
			
		}
	}
	
	public static void main (String[] args) {
		Game POKEMON = new Game();
		POKEMON.play();
	}
	
}
