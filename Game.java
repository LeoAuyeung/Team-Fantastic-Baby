//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Game.java

import java.util.ArrayList;
import Pokedex.*;
//Credits to http://www.pokemon.com/ for Pokedex descriptions of all available Pokemon in our game!

public class Game {
	
	//For keeping track of Pokemon
    private ArrayList<Pokemon> _Pokemon = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> _PokemonEnemy = new ArrayList<Pokemon>();
    private int selectedPokemon, capturedPokemon;
	//Instantiating global classes
    private Pokemon captured, currentPokemon, enemyPokemon;
    private Map userMap;    
    private Battle battle = new Battle();
    private Inventory bag = new Inventory();
	private Trainer foe;
	//For keeping track of battles/turns
    private boolean battleMode = false;
    private boolean opponentTurn = false;
    //For display
    private String systemMsg = "";
	private int battleScreen;
	
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
		System.out.println( commands );
	}
	
	public void displayMapMsg() {
		
	}
	
	//~~~~~~~~~~~~~~~BATTLE-DISPLAYS~~~~~~~~~~~~~~~~
	
	//Main battle display (Player's Pokemon, Enemy Pokemon, Battle Menu)
	public void displayBattle() {
		//Main Menu
		if ( battleScreen == 0 ) { displayBattleMenu(); } 
		//List of Moves (Fight)
		if ( battleScreen == 1 ) { displayFight(); }
		//List of Bag
		if ( battleScreen == 2 ) { displayBag(); }
		//List of Pokemon (Pokemon)
		if ( battleScreen == 3 ) { displayPokemon(); }
		
		//Inside inventory
		//List of Pokeballs
		if ( battleScreen == 4 ) { displayBag1(); }
		//List of Potions
		if ( battleScreen == 5 ) { displayBag2(); }
		//List of Battle Items
		if ( battleScreen == 6 ) { displayBag3(); }
		
	}
	
	public void displaySystemMsg() {
		//Creates a pause before displaying
		waitMS(1000);
		//1/2 of the screen
		displayBattlefield();
		//1/2 of the screen
		if( systemMsg.length() < 39 ) {
			Battle.set( 12, 0, "         ============================================" );
			Battle.set( 13, 0, "         ||                                        ||" );
			Battle.set( 14, 0, "         || " + indent(systemMsg, 39) + "||");
			Battle.set( 15, 0, "         ||                                        ||" );
			Battle.set( 16, 0, "         ============================================" );
		}
		else if( systemMsg.length() >= 39 ) {
			String line1 = systemMsg.substring(0, lastWord(systemMsg, 38));
			String line2 = systemMsg.substring(lastWord(systemMsg, 38) + 1);
			Battle.set( 12, 0, "         ============================================" );
			Battle.set( 13, 0, "         ||                                        ||" );
			Battle.set( 14, 0, "         || " + indent(line1, 39) + "||");           
			Battle.set( 15, 0, "         || " + indent(line2, 39) + "||" );
			Battle.set( 16, 0, "         ||                                        ||" );
			Battle.set( 17, 0, "         ============================================" );
		}
		//Displays field + msg
		System.out.println(battle);
		
		//Creates a pause after displaying
		waitMS( 1500 );
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
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
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
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
		Battle.set( 9, 0, center("WHAT WILL " + currentPokemon.getName() + " DO?", 59).substring(0,54) + "B: BACK" );
		Battle.set( 11, 0, "      --------------------       --------------------" );
		Battle.set( 12, 0, "      |" + indent(" (1) " + currentPokemon.getMovesName(0), 18) + "|" );
		Battle.set( 13, 0, "      |" + indent(" [" + currentPokemon.getMovesType(0) + "] PP " + currentPokemon.getPP(0) + "/" + currentPokemon.getMaxPP(0), 18) + "|" );
		Battle.set( 14, 0, "      --------------------       --------------------" );
		Battle.set( 16, 0, "      --------------------       --------------------" ); 
		Battle.set( 17, 0, "      |" + indent(" (3) " + currentPokemon.getMovesName(2), 18) + "|" );
		Battle.set( 18, 0, "      |" + indent(" [" + currentPokemon.getMovesType(2) + "] PP " + currentPokemon.getPP(2) + "/" + currentPokemon.getMaxPP(2), 18) + "|" );
		Battle.set( 19, 0, "      --------------------       --------------------" );
		Battle.set( 12, 1, "       |" + indent(" (2) " + currentPokemon.getMovesName(1), 18) + "|" );
		Battle.set( 13, 1, "       |" + indent(" [" + currentPokemon.getMovesType(1) + "] PP " + currentPokemon.getPP(1) + "/" + currentPokemon.getMaxPP(1), 18) + "|" );
		Battle.set( 17, 1, "       |" + indent(" (4) " + currentPokemon.getMovesName(3), 18) + "|" );
		Battle.set( 18, 1, "       |" + indent(" [" + currentPokemon.getMovesType(3) + "] PP " + currentPokemon.getPP(3) + "/" + currentPokemon.getMaxPP(3), 18) + "|" );
		System.out.println( battle );	    
	}
	
	public void displayBag() {
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
		Battle.set( 9, 0, "                       CHOOSE A BAG                   B: BACK" );
		Battle.set( 11, 0, "                   ------------------" );
		Battle.set( 12, 0, "                   | 1:POKEBALLS    |" );
		Battle.set( 13, 0, "                   ------------------" );
		Battle.set( 14, 0, "                   ------------------" );
		Battle.set( 15, 0, "                   | 2:POTIONS      |" );
		Battle.set( 16, 0, "                   ------------------" );
		Battle.set( 17, 0, "                   ------------------" );
		Battle.set( 18, 0, "                   | 3:BATTLE ITEMS |" );
		Battle.set( 19, 0, "                   ------------------" );
		System.out.println( battle );
	}
	
	public void displayPokemon() {
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
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
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
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
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
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
		//Displays Player's Pokemon & Enemy Pokemon
		displayBattlefield();
		Battle.set( 11, 0, "                       BATTLE ITEMS                   B: BACK" );
		Battle.set( 13, 0, "                  ----------------------" );
		Battle.set( 14, 0, "                  |" + indent( " 1: Protein    x" + bag.getBattleItem(0), 20 ) + "|" );
		Battle.set( 15, 0, "                  ----------------------" );
		Battle.set( 16, 0, "                  |" + indent( " 2: Iron       x" + bag.getBattleItem(0), 20 ) + "|" );
		Battle.set( 17, 0, "                  ----------------------" );	    
		System.out.println( battle );
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~EXECUTE-CONTROLS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Executes Non-Battle Commands
	
	public void executeControl( String command ) {
		int y = Player.getY();
		int x = Player.getX();
		Tile from = Map.get( y, x ); // a var for player's original location
		if ( command.equals("w") ) {
			if( y != 0 ) {
				Tile to = Map.get( y-1, x );
				Player.setDirection( "UP" );
				if( !to.isObstacle() ) {
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
		}// ends "w" command
		
		if ( command.equals("a") ) {
			if( x!= 0 ) {
				Tile to = Map.get( y, x-1 );
				Player.setDirection( "LEFT" );
				if( !to.isObstacle() ) {
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
		} // ends "a" command
		
		if ( command.equals("s") ) {
			if( y!=19 ) {
				Tile to = Map.get( y+1, x );
				Player.setDirection( "DOWN" );	    
				if( !to.isObstacle() ) {
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
		} // ends "S" command
		
		if ( command.equals("d") ) {
			if( x!=19 ) {
				Tile to = Map.get( y, x+1 );
				Player.setDirection( "RIGHT" );	    
				if( !to.isObstacle() ) {
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
		} // ends "d" command
		
		
		if ( command.equals("x") ) {
			//check block in front using player.getDirection()
			//we will have: trees, rocks, walls, enemy trainers
		}
		
	}//ends NON-BATTLE COMMANDS
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Executes Battle Commands~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void executeBattleControl ( String command ) {
		//LIST OF CONTROLS: http://pokemonessentials.wikia.com/wiki/Controls
		//SETTING POKEMON CONTROLS: http://pokemonessentials.wikia.com/wiki/Tutorial:Set_the_Controls_Screen
		
		//~~~~~~~~~~~~~~~~~~~~Battle Menu~~~~~~~~~~~~~~~~~~~~
		if ( battleScreen == 0 ) {
			if ( command.equals("1") ) { battleScreen = 1; } //Fight
			if ( command.equals("2") ) { battleScreen = 2; } //Bag
			if ( command.equals("3") ) { battleScreen = 3; } //Pokemon
			if ( command.equals("4") ) { //Run
				if ( enemyPokemon.getWild() == false ) { systemMsg = "You cannot run from a trainer battle..."; displaySystemMsg(); }
				else if (Math.random() * 100 < 50) {
					//if wild pkmn, chance of running = http://bulbapedia.bulbagarden.net/wiki/Escape#Success_conditions
					waitMS(375);
					systemMsg = "You have successfully escaped!";
					displaySystemMsg();
					waitMS(1000);
					battleMode = false;
				}
				else {
					waitMS(375);
					systemMsg = "You have failed to run away...";
					displaySystemMsg();
					waitMS(1000);
					endTurn();
				}
			}
		}
		
		//~~~~~~~~~~~~~~~~~~~~Fight~~~~~~~~~~~~~~~~~~~~
		else if ( battleScreen == 1 ) {
			//Goes back to previous screen
			if ( command.equals("b") ) { battleScreen = 0; }
			
			//Attacks with first move
			else if ( command.equals("1") && currentPokemon.getPP(0) != 0 ) {
				//Changes system msg & displays it
				systemMsg = currentPokemon.getName() + " used " + currentPokemon.getMovesName(0) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				currentPokemon.attack( enemyPokemon, 0 );
				if ( currentPokemon.hasWeak( enemyPokemon.getType() )) {
					systemMsg = "It's not very effective...";
					displaySystemMsg();
				}
				else if ( currentPokemon.hasStr( enemyPokemon.getType() )) {
					systemMsg = "It's super effective!";
					displaySystemMsg();
				}
				endTurn();
			}
			
			//Attacks with second move
			else if ( command.equals("2") && currentPokemon.getPP(1) != 0) {
				//Changes system msg & displays it
				systemMsg = currentPokemon.getName() + " used " + currentPokemon.getMovesName(1) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				currentPokemon.attack( enemyPokemon, 1 );
				if ( currentPokemon.hasWeak( enemyPokemon.getType() )) {
					systemMsg = "It's not very effective...";
					displaySystemMsg();
				}
				else if ( currentPokemon.hasStr( enemyPokemon.getType() )) {
					systemMsg = "It's super effective!";
					displaySystemMsg();
				}
				endTurn();
			}
			
			//Attacks with third move
			else if ( command.equals("3") && currentPokemon.getPP(2) != 0 && currentPokemon.getMovesNum() >= 3 ) {
				//Changes system msg & displays it
				systemMsg = currentPokemon.getName() + " used " + currentPokemon.getMovesName(2) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				currentPokemon.attack( enemyPokemon, 2 );
				if ( currentPokemon.hasWeak( enemyPokemon.getType() )) {
					systemMsg = "It's not very effective...";
					displaySystemMsg();
				}
				else if ( currentPokemon.hasStr( enemyPokemon.getType() )) {
					systemMsg = "It's super effective!";
					displaySystemMsg();
				}
				endTurn();
			}
			
			//Attacks with fourth move
			else if ( command.equals("4") && currentPokemon.getPP(3) != 0 && currentPokemon.getMovesNum() == 4 ) {
				//Changes system msg & displays it
				systemMsg = currentPokemon.getName() + " used " + currentPokemon.getMovesName(3) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				currentPokemon.attack( enemyPokemon, 3 );
				if ( currentPokemon.hasWeak( enemyPokemon.getType() )) {
					systemMsg = "It's not very effective...";
					displaySystemMsg();
				}
				else if ( currentPokemon.hasStr( enemyPokemon.getType() )) {
					systemMsg = "It's super effective!";
					displaySystemMsg();
				}
				endTurn();
			}
			
			//Goes to error message
			else {
				systemMsg = "Invalid move...";
				displaySystemMsg();
				battleScreen = 1;
			}
			
		}
		
		//~~~~~~~~~~~~~~~~~~~~Bag~~~~~~~~~~~~~~~~~~~~
		else if ( battleScreen == 2 ) {
			if ( command.equals("1") ) { battleScreen = 4; } //Pokeballs
			if ( command.equals("2") ) { battleScreen = 5; } //Potions
			if ( command.equals("3") ) { battleScreen = 6; } //Battle Items
			if ( command.equals("b") ) { battleScreen = 0; } //Goes back to previous screen
		}
		
		//~~~~~~~~~~~~~~~~~~~~Pokemon~~~~~~~~~~~~~~~~~~~~
		else if ( battleScreen == 3 ) {
			//Takes input and converts to int
			try {
				selectedPokemon = Integer.parseInt( command );
				selectedPokemon = selectedPokemon - 1;
			}
			catch (Exception e) { battleScreen = 3; }
			
			//Goes back to previous screen
			if ( command.equals("b") ) { battleScreen = 0; }
			
			//Switches Pokemon
			else if ( selectedPokemon < capturedPokemon && !( _Pokemon.get(selectedPokemon).equals(currentPokemon) ) && !(_Pokemon.get(selectedPokemon).fainted()) ) {
				//Displays "come back" msg
				systemMsg = currentPokemon.getName() + ", switch out! Come back!";
				displaySystemMsg();
				//Swaps Pokemon & displays "go" msg
				currentPokemon = _Pokemon.get( selectedPokemon ); //Swaps out Pokemon
				systemMsg = "Go! " + currentPokemon.getName() + "!";
				displaySystemMsg();
				endTurn();
			}
			
			//Trying to swap with same Pokemon
			else if ( _Pokemon.get(selectedPokemon).equals(currentPokemon) ) { systemMsg = "You cannot switch with the same Pokemon..."; displaySystemMsg(); }
			
			//Trying to swap with fainted Pokemon
			else if ( _Pokemon.get(selectedPokemon).fainted() ) { systemMsg = "You cannot switch with a fainted Pokemon..."; displaySystemMsg(); }
			
			//Goes to error message
			else { systemMsg = "Invalid Pokemon choice..."; displaySystemMsg(); }
			
		}
		
		//~~~~~~~~~~~~~~~~~~~~Bag -- Pokeballs~~~~~~~~~~~~~~~~~~~~
		//Using: http://bulbapedia.bulbagarden.net/wiki/Catch_rate#Modified_catch_rate_3
		else if ( battleScreen == 4 ) {
			int ball = 0;
			//Goes back to previous screen
			if ( command.equals("b") ) { battleScreen = 2; }
			//Uses Poke Ball
			else if ( command.equals("1") && bag.getPokeball(0) != 0 && capturedPokemon < 6 ) {
				//Displays first system msg
				ball = 0;
				systemMsg = Player.getName() + " used one Poke Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 1) / (double)(3 * enemyPokemon.getMaxHP()) );
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 0.5 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false;}
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Great Ball
			else if ( command.equals("2") && bag.getPokeball(1) != 0 && capturedPokemon < 6 ) {
				//Displays first system msg
				ball = 1;
				systemMsg = Player.getName() + " used one Great Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 1.5) / (double)(3 * enemyPokemon.getMaxHP()) );
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 0.6 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false; }
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Ultra Ball
			else if ( command.equals("3") && bag.getPokeball(2) != 0 && capturedPokemon < 6 ) {
				//Displays first system msg
				ball = 2;
				systemMsg = Player.getName() + " used one Ultra Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 2) / (double)(3 * enemyPokemon.getMaxHP()) );
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 0.6 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false; }
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Master Ball
			else if ( command.equals("4") && bag.getPokeball(3) != 0 && capturedPokemon < 6 ) {
				//Displays first system msg
				ball = 3;
				systemMsg = Player.getName() + " used one Master Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = 255;
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 0.6 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false; }
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Already have 6 Pokemon
			else if ( capturedPokemon == 6 ) { systemMsg = "You cannot catch any more Pokemon!"; displaySystemMsg(); }
			
			//Goes to error message
			else { systemMsg = "Invalid Pokeball..."; displaySystemMsg(); }
			
		}//ends Bag -- Pokeballs
		
		//~~~~~~~~~~~~~~~~~~~~Bag -- Potions~~~~~~~~~~~~~~~~~~~~
		else if ( battleScreen == 5 ) {
			int pot = 0;
			int hpRestored = 0;
			int ppRestored = 0;
			int hpDiff = currentPokemon.getMaxHP() - currentPokemon.getHP();
			//Goes back to previous screen
			if ( command.equals("b") ) { battleScreen = 2; }
			//Uses Potion
			else if ( command.equals("1") && bag.getPotion(0) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) {
				//Displays first system msg
				pot = 0;
				hpRestored = 20;
				systemMsg = "Player used a Potion!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				if ( hpDiff < hpRestored ) { hpRestored = hpDiff; }
				currentPokemon.restoreHP( hpRestored );
				//Displays system msg with restored hp
				String hp = Integer.toString( hpRestored );
				systemMsg = currentPokemon.getName() + " restored " + hp + " HP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Super Potion
			else if ( command.equals("2") && bag.getPotion(1) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Super Potion
				//Displays first system msg
				pot = 1;
				hpRestored = 50;
				systemMsg = "Player used a Super Potion!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				if ( hpDiff < hpRestored ) { hpRestored = hpDiff; }
				currentPokemon.restoreHP( hpRestored );
				//Displays system msg with restored hp
				String hp = Integer.toString( hpRestored );
				systemMsg = currentPokemon.getName() + " restored " + hp + " HP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Hyper Potion
			else if ( command.equals("3") && bag.getPotion(2) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Hyper Potion
				//Displays first system msg
				pot = 2;
				hpRestored = 200;
				systemMsg = "Player used a Hyper Potion!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				if ( hpDiff < hpRestored ) { hpRestored = hpDiff; }
				currentPokemon.restoreHP( hpRestored );
				//Displays system msg with restored hp
				String hp = Integer.toString( hpRestored );
				systemMsg = currentPokemon.getName() + " restored " + hp + " HP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Max Potion
			else if ( command.equals("4") && bag.getPotion(3) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() ) { //Uses Max Potion
				//Displays first system msg
				pot = 3;
				hpRestored = 999;
				systemMsg = "Player used a Max Potion!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				currentPokemon.restoreHP( hpRestored );
				//Displays system msg with restored hp
				systemMsg = currentPokemon.getName() + " restored all of its HP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Elixir
			else if ( command.equals("5") && bag.getPotion(4) != 0 && !currentPokemon.allMaxPP() ) { //Uses Elixir
				//Displays first system msg
				pot = 4;
				ppRestored = 10;
				systemMsg = "Player used an Elixir!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				currentPokemon.restorePP( ppRestored );
				//Displays system msg with restored hp
				String pp = Integer.toString( ppRestored );
				systemMsg = "All of " + currentPokemon.getName() + "'s moves restored 10 PP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Max Elixir
			else if ( command.equals("6") && bag.getPotion(5) != 0 && !currentPokemon.allMaxPP() ) { //Uses Max Elixir
				//Displays first system msg
				pot = 5;
				systemMsg = "Player used a Max Elixir!";
				displaySystemMsg();
				bag.lowerAmount( 1, pot );
				//Does math for hpRestored
				currentPokemon.restorePP( ppRestored );
				//Displays system msg with restored hp
				systemMsg = "All of " + currentPokemon.getName() + "'s moves restored all of its PP!";
				displaySystemMsg();
				endTurn();
			}
			
			//Pokemon at max HP
			else if ( currentPokemon.getHP() == currentPokemon.getMaxHP() ) { systemMsg = currentPokemon.getName() + " is already at full HP!"; displaySystemMsg(); }
			
			//Pokemon at max PP
			else if ( currentPokemon.allMaxPP() ) { systemMsg = currentPokemon.getName() + "'s moves are at full PP!"; displaySystemMsg(); }
			
			//Goes to error message
			else { systemMsg = "Invalid Potion..."; displaySystemMsg(); }
			
		}//ends Bag -- Potions
		
		//~~~~~~~~~~~~~~~~~~~~Bag -- Battle Items~~~~~~~~~~~~~~~~~~~~
		else if ( battleScreen == 6 ) {
			//Goes back to previous screen
			if ( command.equals("b") ) { battleScreen = 2; }
			
			//Uses Protein
			else if ( command.equals("1") && bag.getBattleItem(0) != 0 ) {
				//Displays first system message
				systemMsg = "Player used one Calcium!";
				displaySystemMsg();
				currentPokemon.setAttack( currentPokemon.getAttack() + 10 );
				bag.lowerAmount(2, 0);
				//Displays Pokemon's Attack increasing
				systemMsg = currentPokemon.getName() + "'s Attack went up by 10!";
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Iron
			else if ( command.equals("2") && bag.getBattleItem(1) != 0 ) {
				//Displays first system message
				systemMsg = "Player used one Iron!";
				currentPokemon.setDefense( currentPokemon.getDefense() + 10 );
				bag.lowerAmount(2, 1);
				//Displays Pokemon's Defense increasing
				systemMsg = currentPokemon.getName() + "'s Defense went up by 10!";
				displaySystemMsg();
				endTurn();
			}
			
			//Goes to error message
			else { systemMsg = "Invalid Battle Item..."; displaySystemMsg(); }
			
		}//ends Bag -- Battle Items
		
	}//ends BATTLE COMMANDS
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~OPPONENT BATTLE DISPLAY AND EXECUTE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void opponentBattle() {
		if ( battleMode == true && opponentTurn == true ) {
			String name = "";
			if ( enemyPokemon.getWild() == true ) {
				name = "Wild " + enemyPokemon.getName();
			}
			else if ( enemyPokemon.getWild() == false ) {
				name = foe.getName() + "'s " + enemyPokemon.getName();
			}
			//***********not sure if we want this test it out
			//Display an empty message for aesthetics
			systemMsg = "";
			displaySystemMsg();
			
			//If Enemy Fainted
			if ( enemyPokemon.fainted() == true ) {
				systemMsg = name + " has fainted!";
				displaySystemMsg();
				//Pokemon gains exp
				systemMsg = currentPokemon.getName() + " has gained " + gainEXP() + " Exp. Points!";
				displaySystemMsg();
				//If Pokemon has exp to level up
				while ( currentPokemon.getEXP() > currentPokemon.getLevelEXP() ) {
					currentPokemon.levelUp();
					systemMsg = currentPokemon.getName() + " grew to Lv. " + currentPokemon.getLevel() + "!";
					displaySystemMsg();
				}
				battleMode = false;
			}
			
			//If Enemy is still alive
			else {
				//Changes system msg & displays it
				systemMsg = name + " used " + enemyPokemon.getMovesName(0) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				enemyPokemon.attack( currentPokemon, 0 );
				if ( enemyPokemon.hasWeak( currentPokemon.getType() )) {
					systemMsg = "It's not very effective...";
					displaySystemMsg();
				}
				else if ( enemyPokemon.hasStr( currentPokemon.getType() )) {
					systemMsg = "It's super effective!";
					displaySystemMsg();
				}
				else { waitMS(500); }
			}
			//Trainer sent out New Pokemon!
			//Player has defeated Trainer! Player has earned $500
			endTurn();
		}
	}
	
	public void afterBattle() {
		//If player's Pokemon fainted
		if ( currentPokemon.fainted() == true ) {
			Player.setPokemonLeft( Player.getPokemonLeft() - 1 );
			systemMsg = currentPokemon.getName() + " fainted!";
			displaySystemMsg();
			//Prompts for new Pokemon to send out if able
			while ( currentPokemon.fainted() == true && !Player.blackedOut() ) {
				displayPokemon();
				String control = Keyboard.readString();
				try {
					selectedPokemon = Integer.parseInt( control );
					selectedPokemon = selectedPokemon - 1;
				}
				catch (Exception e) { battleScreen = 3; }
				
				//Sends out Pokemon
				if ( selectedPokemon < capturedPokemon && !( _Pokemon.get(selectedPokemon).equals(currentPokemon) ) && !(_Pokemon.get(selectedPokemon).fainted()) ) {
					//Displays "Go" msg
					systemMsg = "Go " + (_Pokemon.get(selectedPokemon)).getName() + "!";
					displaySystemMsg();
					currentPokemon = _Pokemon.get(selectedPokemon);
				}
				
				//Trying to swap with fainted Pokemon
				else if ( _Pokemon.get(selectedPokemon).fainted() ) { systemMsg = "You cannot send out a fainted Pokemon..."; displaySystemMsg(); }
				
				//Goes to error message
				else { systemMsg = "Invalid Pokemon choice..."; displaySystemMsg(); }
			}
			//If player has no more Pokemon
			if ( Player.blackedOut() ) {
				systemMsg = Player.getName() + " has blacked out!";
				displaySystemMsg();
				battleMode = false;
			}
		}
		
		//Evolution
		//else if ( currentPokemon.getLevel() >= currentPokemon.getEvolveLevel() ) { evolve(); }
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~EVOLUTION~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/*public void evolve() {
		int lvl = currentPokemon.getLevel();
		int xp = currentPokemon.getEXP();
		String name = currentPokemon.getName();
		String newMove = "";
		//Displays "What? Pokemon is evolving!"
		systemMsg = "What? " + name + " is evolving!";
		displaySystemMsg();
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ALL EVOLUTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		if ( currentPokemon.getName().equals( "CHARMANDER" ) ) { currentPokemon = new Charmeleon( "CHARMELEON", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//Permanently sets the new Pokemon in arrayList of Pokemon
		_Pokemon.set(selectedPokemon, currentPokemon);
		
		//Displays "Congratulations! Your Pokemon evolved into New Pokemon!"
		systemMsg = "Congratulations! Your " + name + " evolved into " + currentPokemon.getName() + "!";
		displaySystemMsg();
		//Displays "New Pokemon has learned New Move!"
		systemMsg = currentPokemon.getName() + " has learned " + newMove + "!";
		displaySystemMsg();
	}*/
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MISC USEFUL HELPER FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Capturing pokemon
	public void capturePokemon( Pokemon p ) {
		capturedPokemon = capturedPokemon + 1;
		_Pokemon.set( capturedPokemon - 1, p );
	}
	
	//Starting a Pokemon Battle
	public void battleStart() {
		battleMode = true;
		opponentTurn = false;
		enemyPokemon = new Oddish();
		enemyPokemon.setWild(true);
		//later implement diff wild pkmn on random chance
		selectedPokemon = 0;
		currentPokemon = _Pokemon.get(selectedPokemon);
	}
	
	//Ends turn
	public void endTurn() {
		opponentTurn = !opponentTurn;
		battleScreen = 0;
	}
	
	//Gaining exp/leveling up
	public int gainEXP() {
		int gained;
		//Math for exp gain
		gained = 200;
		currentPokemon.gainEXP(gained);
		return gained;
	}
	
	//Method to turn HP into a bar
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
	
	//Method to turn EXP into a bar
	public String displayEXP( Pokemon p ) {
		double eachBar = ( ( p.getLevelEXP() ) / 20.0 ); // this is how much exp each bar is worth
		int numBar = (int)( ( p.getEXP() ) / eachBar ); // number of bars displayed
		int maxBar = 20;
		if ( numBar > maxBar ) { numBar = 20; }
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
	
	//Helper method to equally space out the first column of "displayPokemon()"
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
	public int lastWord( String s, int x ) { // returns the index where the last word begins
		String temp = new String( s );
		int index = 0;
		for( int i = x; i >= 0; i-- ) {
			if( temp.substring(i).equals(" ") ) {
				index = i;
				break;
			}
			temp = temp.substring(0,i);
		}
		return index;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END MISC FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PLAYING POKEMON!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
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
		captured = new Rattata();
		capturePokemon(captured);
		
		//RUNS GAME:
		while ( user.getQuest() != 20 ) {
			
			userMap = new Map(Player.getMapNum());
			
			if ( battleMode == false ) {
				//Not in battle -> display map + map controls
				System.out.println(userMap);
				displayCommands();
				String control = promptControl();
				executeControl(control);
				//displayMapMsg(); displays map messages when interacting
			}
			else if ( battleMode == true ) {
				//In battle -> display battlefield + battle menus
				displayBattle();
				String control = promptControl();
				executeBattleControl(control);
				//When opponentTurn is true
				opponentBattle();
				//After battle has ended
				afterBattle();
			}
			System.out.println("battleMode (FOR TESTING): " + battleMode);
			System.out.println("selectedPkmn (FOR TESTING): " + selectedPokemon);
			
		}
	}
	
	public static void main (String[] args) {
		Game POKEMON = new Game();
		POKEMON.play();
	}
	
}
