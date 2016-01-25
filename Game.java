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
	private Trainer enemy;
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
		waitMS(750);
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
		waitMS( 1250 );
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
					userMap = new Map(Player.getMapNum());
				}
				if( to.getType().equals("BackPortal") ) {
					Player.setMapNum( Player.getMapNum()-1 );
					userMap = new Map(Player.getMapNum());
				}	    
				//user.setX, user.setY, change map's player coordinates
				if( to.getType().equals("Grass")||to.getType().equals("Cave")) {
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
					userMap = new Map(Player.getMapNum());
				}
				if( to.getType().equals("BackPortal") ) {
					Player.setMapNum( Player.getMapNum()-1 );
					userMap = new Map(Player.getMapNum());
				}	    
				//user.setX, user.setY, change map's player coordinates
				if( to.getType().equals("Grass")||to.getType().equals("Cave") ) {
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
					userMap = new Map(Player.getMapNum());
				}
				if( to.getType().equals("BackPortal") ) {
					Player.setMapNum( Player.getMapNum()-1 );
					userMap = new Map(Player.getMapNum());
				}	    
				//user.setX, user.setY, change map's player coordinates
				if( to.getType().equals("Grass")||to.getType().equals("Cave") ) {
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
					userMap = new Map(Player.getMapNum());					
				}
				if( to.getType().equals("BackPortal") ) {
					Player.setMapNum( Player.getMapNum()-1 );
					userMap = new Map(Player.getMapNum());					
				}	    
				//user.setX, user.setY, change map's player coordinates
				if( to.getType().equals("Grass")||to.getType().equals("Cave") ) {
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
			else if ( command.equals("1") && bag.getPokeball(0) != 0 && capturedPokemon < 6 && enemyPokemon.getWild() == true ) {
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
			else if ( command.equals("2") && bag.getPokeball(1) != 0 && capturedPokemon < 6 && enemyPokemon.getWild() == true ) {
				//Displays first system msg
				ball = 1;
				systemMsg = Player.getName() + " used one Great Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 1.5) / (double)(3 * enemyPokemon.getMaxHP()) );
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 1.0 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false; }
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Ultra Ball
			else if ( command.equals("3") && bag.getPokeball(2) != 0 && capturedPokemon < 6 && enemyPokemon.getWild() == true ) {
				//Displays first system msg
				ball = 2;
				systemMsg = Player.getName() + " used one Ultra Ball!";
				displaySystemMsg();
				bag.lowerAmount( 0, ball );
				//Does math for catching Pokemon
				double RNG = Math.random() + 1;
				double catchRate = ( ( (double)(3 * enemyPokemon.getMaxHP()) - (double)(2 * enemyPokemon.getHP()) * RNG * 2) / (double)(3 * enemyPokemon.getMaxHP()) );
				//Displays system msg depending on whether Pokemon was caught or not
				if ( catchRate >= 1.5 ) { capturePokemon( enemyPokemon ); systemMsg = "Gotcha! " + enemyPokemon.getName() + " was caught!"; battleMode = false; }
				else { systemMsg = enemyPokemon.getName() + " broke free!"; }
				displaySystemMsg();
				endTurn();
			}
			
			//Uses Master Ball
			else if ( command.equals("4") && bag.getPokeball(3) != 0 && capturedPokemon < 6 && enemyPokemon.getWild() == true ) {
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
			
			//Cannot catch a trainer's Pokemon
			else if ( enemyPokemon.getWild() == false ) { systemMsg = "The Trainer blocked the Ball!"; displaySystemMsg(); }
			
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
			else if ( command.equals("1") && bag.getPotion(0) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() && currentPokemon.getHP() != 0 ) {
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
			else if ( command.equals("2") && bag.getPotion(1) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() && currentPokemon.getHP() != 0 ) { //Uses Super Potion
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
			else if ( command.equals("3") && bag.getPotion(2) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() && currentPokemon.getHP() != 0 ) { //Uses Hyper Potion
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
			else if ( command.equals("4") && bag.getPotion(3) != 0 && currentPokemon.getHP() != currentPokemon.getMaxHP() && currentPokemon.getHP() != 0 ) { //Uses Max Potion
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
				name = enemy.getName() + "'s " + enemyPokemon.getName();
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
				
				//Ends battle if vs Wild pokemon
				if ( enemyPokemon.getWild() == true ) { battleMode = false; }
				
				//If Trainer battle, reduce pokemon left by 1
				else if ( enemyPokemon.getWild() == false ) {
					enemy.setPokemonLeft( enemy.getPokemonLeft() - 1 );
					//If trainer still has pokemon left, sends out next Pokemon
					if ( enemy.getPokemonLeft() != 0 ) {
						int selectedPkmn = enemy.getTotalPokemon() - enemy.getPokemonLeft();
						enemyPokemon = enemy.getPokemon( selectedPkmn );
						systemMsg = enemy.getName() + " has sent out " + enemyPokemon.getName() + "!";
						displaySystemMsg();
					}
				}
			}
			
			//If Enemy is still alive
			else {
				int move = (int) ( Math.random() * (enemyPokemon.getMovesNum()) );
				while ( enemyPokemon.getPP(move) == 0 ) { move = (int) ( Math.random() + (enemyPokemon.getMovesNum() - 1) ); }
				//Changes system msg & displays it
				systemMsg = name + " used " + enemyPokemon.getMovesName(move) + "!";
				displaySystemMsg();
				//Attack and change system msg + display effectiveness
				enemyPokemon.attack( currentPokemon, move );
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
			//Ends turn afterwards
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
			while ( currentPokemon.fainted() == true && !( Player.blackedOut() ) ) {
				displayPokemon();
				String control = Keyboard.readString();
				try {
					selectedPokemon = Integer.parseInt( control );
					selectedPokemon = selectedPokemon - 1;
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
				catch (Exception e) { systemMsg = "Invalid Pokemon choice..."; displaySystemMsg(); }
			}
			
			//If player has no more Pokemon
			if ( Player.blackedOut() ) {
				systemMsg = Player.getName() + " has blacked out!";
				displaySystemMsg();
				battleMode = false;
			}
		}
		
		//If enemy trainer blacked out
		else if ( enemyPokemon.getWild() == false && enemy.blackedOut() ) {
			//Displays victory message
			systemMsg = Player.getName() + " has defeated " + enemy.getName()+ "!";
			displaySystemMsg();
			//Displays gaining money
			int money = enemy.getDifficulty() * 750;
			systemMsg = Player.getName() + " has earned $" + money + "!";
			displaySystemMsg();
			battleMode = false;
			
			//Enemy is a gym leader
			if ( enemy.isGymLeader() == true ) {
				Player.setBadges( Player.getBadges() + 1 );
				systemMsg = Player.getName() + " has earned the " + enemy.getType() + " badge!";
				displaySystemMsg();
				//Earning Rock Smash after 1st gym
				if ( Player.getBadges() == 1 ) { bag.addKeyItem("HM06--Rock Smash"); systemMsg = Player.getName() + " has earned the item 'HM06--Rock Smash'!"; displaySystemMsg(); }
				//Earning Cut after 2nd gym
				else if ( Player.getBadges() == 2 ) { bag.addKeyItem("HM01--Cut"); systemMsg = Player.getName() + " has earned the item 'HM01--Cut'!"; displaySystemMsg(); }
				//Earning a Master Ball after 3rd gym
				else if ( Player.getBadges() == 3 ) { bag.addAmount(0, 3, 1); systemMsg = Player.getName() + " has earned the item 'HM01--Cut'!"; displaySystemMsg(); }
			}
		}
		
		//Evolution
		if ( battleMode == false && currentPokemon.getLevel() >= currentPokemon.getEvolveLevel() ) { evolve(); }
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~EVOLUTION~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void evolve() {
		int lvl = currentPokemon.getLevel();
		int xp = currentPokemon.getEXP();
		String name = currentPokemon.getName();
		String newMove = "";
		//Displays "What? Pokemon is evolving!"
		systemMsg = "What? " + name + " is evolving!";
		displaySystemMsg();
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ALL EVOLUTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//Starters
		if ( currentPokemon.getName().equals( "Bulbasaur" ) ) { currentPokemon = new Ivysaur( "Ivysaur", lvl, 32 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Ivysaur" ) ) { currentPokemon = new Venusaur( "Venusaur", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Charmander" ) ) { currentPokemon = new Charmeleon( "Charmeleon", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Charmeleon" ) ) { currentPokemon = new Charizard( "Charizard", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Squirtle" ) ) { currentPokemon = new Wartortle( "Wartortle", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Wartortle" ) ) { currentPokemon = new Blastoise( "Blastoise", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Normal
		else if ( currentPokemon.getName().equals( "Rattata" ) ) { currentPokemon = new Raticate( "Raticate", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Jigglypuff" ) ) { currentPokemon = new Wigglytuff( "Wigglytuff", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Zigzagoon" ) ) { currentPokemon = new Linoone( "Linoone", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		//Fire
		else if ( currentPokemon.getName().equals( "Vulpix" ) ) { currentPokemon = new Ninetales( "Ninetales", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Growlithe" ) ) { currentPokemon = new Arcanine( "Arcanine", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Ponyta" ) ) { currentPokemon = new Rapidash( "Rapidash", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		//Water
		else if ( currentPokemon.getName().equals( "Psyduck" ) ) { currentPokemon = new Golduck( "Golduck", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Magikarp" ) ) { currentPokemon = new Gyarados( "Gyarados", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Carvanha" ) ) { currentPokemon = new Sharpedo( "Sharpedo", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		//Electric
		else if ( currentPokemon.getName().equals( "Pichu" ) ) { currentPokemon = new Pikachu( "Pikachu", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Pikachu" ) ) { currentPokemon = new Raichu( "Charmeleon", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Magnemite" ) ) { currentPokemon = new Magneton( "Magneton", lvl, 45 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Magneton" ) ) { currentPokemon = new Magnezone( "Magnezone", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Elekid" ) ) { currentPokemon = new Electabuzz( "Electabuzz", lvl, 45 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Electabuzz" ) ) { currentPokemon = new Electivire( "Electivire", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Grass
		else if ( currentPokemon.getName().equals( "Oddish" ) ) { currentPokemon = new Gloom( "Gloom", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Gloom" ) ) { currentPokemon = new Vileplume( "Vileplume", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Budew" ) ) { currentPokemon = new Roselia( "Roselia", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Roselia" ) ) { currentPokemon = new Roserade( "Roserade", lvl, 36 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Ice
		else if ( currentPokemon.getName().equals( "Snorunt" ) ) { currentPokemon = new Glalie( "Glalie", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Spheal" ) ) { currentPokemon = new Sealeo( "Sealeo", lvl, 44 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Sealeo" ) ) { currentPokemon = new Walrein( "Walrein", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Fighting
		else if ( currentPokemon.getName().equals( "Machop" ) ) { currentPokemon = new Machoke( "Machoke", lvl, 44 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Machoke" ) ) { currentPokemon = new Machamp( "Machamp", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Riolu" ) ) { currentPokemon = new Lucario( "Lucario", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		//Flying
		else if ( currentPokemon.getName().equals( "Spearow" ) ) { currentPokemon = new Fearow( "Fearow", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Zubat" ) ) { currentPokemon = new Golbat( "Golbat", lvl, 44 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Crobat" ) ) { currentPokemon = new Crobat( "Crobat", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Rock
		else if ( currentPokemon.getName().equals( "Geodude" ) ) { currentPokemon = new Graveler( "Graveler", lvl, 44 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Graveler" ) ) { currentPokemon = new Golem( "Golem", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		//Dark
		else if ( currentPokemon.getName().equals( "Houndour" ) ) { currentPokemon = new Houndoom( "Houndoom", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Poochyena" ) ) { currentPokemon = new Mightyena( "Mightyena", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(2); }
		//Steel
		else if ( currentPokemon.getName().equals( "Aron" ) ) { currentPokemon = new Lairon( "Lairon", lvl, 42 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Lairon" ) ) { currentPokemon = new Aggron( "Aggron", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		else if ( currentPokemon.getName().equals( "Beldum" ) ) { currentPokemon = new Metang( "Metang", lvl, 45 , xp ); newMove = currentPokemon.getMovesName(2); }
		else if ( currentPokemon.getName().equals( "Metang" ) ) { currentPokemon = new Metagross( "Metagross", lvl, 101 , xp ); newMove = currentPokemon.getMovesName(3); }
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//Permanently sets the new Pokemon in arrayList of Pokemon
		_Pokemon.set(selectedPokemon, currentPokemon);
		
		//Displays "Congratulations! Your Pokemon evolved into New Pokemon!"
		systemMsg = "Congratulations! Your " + name + " evolved into " + currentPokemon.getName() + "!";
		displaySystemMsg();
		//Displays "New Pokemon has learned New Move!"
		systemMsg = currentPokemon.getName() + " has learned " + newMove + "!";
		displaySystemMsg();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MISC USEFUL HELPER FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~MISC BATTLE FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~Starting a Wild Pokemon Battle~~~~~~~~~~~~~~
	public void battleStart() {
		battleMode = true;
		opponentTurn = false;
		currentPokemon = new Default();
		//Spawns wild Pokemon & displays message
		spawnPokemon();
		enemyPokemon.normalize();
		systemMsg = "A wild " + enemyPokemon.getName() + " has appeared!";
		displaySystemMsg();
		//Player calls out first Pokemon & displays message
		selectedPokemon = 0;
		currentPokemon = _Pokemon.get(selectedPokemon);
		systemMsg = "Go! " + currentPokemon.getName() + "!";
		displaySystemMsg();
	}
	
	//Spawns random wild enemy Pokemon
	public void spawnPokemon() {
		//Lvl = ( Map num * 8 ) - random num between 0-5
		int lvl = ( Player.getMapNum() * 8 ) - (int)(Math.random() * 6);
		Pokemon pkmn;
		
		//Easiest Pokemon
		if ( lvl > 0 && lvl <= 16 ) {
			//Random = # of pokemon in list
			int random = (int)(Math.random() * 24);
			if ( random == 0 ) { pkmn = new Rattata (lvl); }
			else if ( random == 1 ) { pkmn = new Jigglypuff (lvl); }
			else if ( random == 2 ) { pkmn = new Zigzagoon (lvl); }
			else if ( random == 3 ) { pkmn = new Vulpix (lvl); }
			else if ( random == 4 ) { pkmn = new Growlithe (lvl); }
			else if ( random == 5 ) { pkmn = new Ponyta (lvl); }
			else if ( random == 6 ) { pkmn = new Psyduck (lvl); }
			else if ( random == 7 ) { pkmn = new Magikarp (lvl); }
			else if ( random == 8 ) { pkmn = new Carvanha (lvl); }
			else if ( random == 9 ) { pkmn = new Pichu (lvl); }
			else if ( random == 10 ) { pkmn = new Magnemite (lvl); }
			else if ( random == 11 ) { pkmn = new Elekid (lvl); }
			else if ( random == 12 ) { pkmn = new Oddish (lvl); }
			else if ( random == 13 ) { pkmn = new Budew (lvl); }
			else if ( random == 14 ) { pkmn = new Spheal (lvl); }
			else if ( random == 15 ) { pkmn = new Machop (lvl); }
			else if ( random == 16 ) { pkmn = new Riolu (lvl); }
			else if ( random == 17 ) { pkmn = new Spearow (lvl); }
			else if ( random == 18 ) { pkmn = new Zubat (lvl); }
			else if ( random == 19 ) { pkmn = new Geodude (lvl); }
			else if ( random == 20 ) { pkmn = new Houndour (lvl); }
			else if ( random == 21 ) { pkmn = new Poochyena (lvl); }
			else if ( random == 22 ) { pkmn = new Aron (lvl); }
			else if ( random == 23 ) { pkmn = new Beldum (lvl); }
			else { pkmn = new Regice (lvl); }
		}
		
		//Medium Pokemon
		else if ( lvl > 16 && lvl <= 32 ) {
			//Random = # of pokemon in list
			int random = (int)(Math.random() * 24);
			if ( random == 0 ) { pkmn = new Raticate (lvl); }
			else if ( random == 1 ) { pkmn = new Wigglytuff (lvl); }
			else if ( random == 2 ) { pkmn = new Linoone (lvl); }
			else if ( random == 3 ) { pkmn = new Ninetales (lvl); }
			else if ( random == 4 ) { pkmn = new Arcanine (lvl); }
			else if ( random == 5 ) { pkmn = new Rapidash (lvl); }
			else if ( random == 6 ) { pkmn = new Golduck (lvl); }
			else if ( random == 7 ) { pkmn = new Gyarados (lvl); }
			else if ( random == 8 ) { pkmn = new Sharpedo (lvl); }
			else if ( random == 9 ) { pkmn = new Pikachu (lvl); }
			else if ( random == 10 ) { pkmn = new Magneton (lvl); }
			else if ( random == 11 ) { pkmn = new Electabuzz (lvl); }
			else if ( random == 12 ) { pkmn = new Gloom (lvl); }
			else if ( random == 13 ) { pkmn = new Roselia (lvl); }
			else if ( random == 14 ) { pkmn = new Snorunt (lvl); }
			else if ( random == 15 ) { pkmn = new Sealeo (lvl); }
			else if ( random == 16 ) { pkmn = new Machoke (lvl); }
			else if ( random == 17 ) { pkmn = new Fearow (lvl); }
			else if ( random == 18 ) { pkmn = new Golbat (lvl); }
			else if ( random == 19 ) { pkmn = new Graveler (lvl); }
			else if ( random == 20 ) { pkmn = new Houndoom (lvl); }
			else if ( random == 21 ) { pkmn = new Mightyena (lvl); }
			else if ( random == 22 ) { pkmn = new Lairon (lvl); }
			else if ( random == 23 ) { pkmn = new Metang (lvl); }
			else { pkmn = new Regirock (lvl); }
		}
		
		//Hard Pokemon
		else if ( lvl > 32 && lvl <= 48 ) {
			//Random = # of pokemon in list
			int random = (int)(Math.random() * 13);
			if ( random == 0 ) { pkmn = new Raichu (lvl); }
			else if ( random == 1 ) { pkmn = new Magnezone (lvl); }
			else if ( random == 2 ) { pkmn = new Electivire (lvl); }
			else if ( random == 3 ) { pkmn = new Vileplume (lvl); }
			else if ( random == 4 ) { pkmn = new Roserade (lvl); }
			else if ( random == 5 ) { pkmn = new Glalie (lvl); }
			else if ( random == 6 ) { pkmn = new Walrein (lvl); }
			else if ( random == 7 ) { pkmn = new Machamp (lvl); }
			else if ( random == 8 ) { pkmn = new Lucario (lvl); }
			else if ( random == 9 ) { pkmn = new Crobat (lvl); }
			else if ( random == 10 ) { pkmn = new Golem (lvl); }
			else if ( random == 11 ) { pkmn = new Aggron (lvl); }
			else if ( random == 12 ) { pkmn = new Metagross (lvl); }
			else { pkmn = new Registeel (lvl); }
			
		}
		else { pkmn = new Regigigas (lvl); }
		
		enemyPokemon = pkmn;
		enemyPokemon.setWild(true);
	}
	
	//~~~~~~~~~~~~~~Starting a Trainer battle~~~~~~~~~~~~~~
	public void trainerBattleStart( boolean leader ) {
		battleMode = true;
		opponentTurn = false;
		//Creation of new trainer
		String name = randomName();
		String type = randomType();
		int diff = Player.getMapNum();
		Pokemon pkmn;
		enemy = new Trainer ( name, diff, type, leader );
		//If gym leader, redistributes Pokemon
		if ( enemy.isGymLeader() ) {
			name = "Gym Leader " + name;
			//First gym is rock type
			if ( Player.getBadges() == 0 ) { enemy.setType("ROCK"); }
			//Second gym is normal type
			else if ( Player.getBadges() == 1 ) { enemy.setType("NORMAL"); }
			//Third gym is Electric type
			else if ( Player.getBadges() == 2 ) { enemy.setType("ELECTRIC"); }
			//Champion is Fighting type, has Mewtwo
			else if ( Player.getBadges() == 3 ) { pkmn = new Mewtwo(); enemy.setType("FIGHTING"); enemy.addPokemon(pkmn); }
			enemy.givePokemon( diff, enemy.getType() );
		}
		else { name = "Foe " + name; }
		enemyPokemon = new Default();
		currentPokemon = new Default();
		//Displays trainer challenging
		systemMsg = "You have been challenged by " + enemy.getName() + "!";
		displaySystemMsg();
		//Trainer sends out Pokemon
		enemyPokemon = enemy.getPokemon(0);
		systemMsg = enemy.getName() + " sent out " + enemyPokemon.getName() + "!";
		displaySystemMsg();
		//Player sends out Pokemon
		selectedPokemon = 0;
		currentPokemon = _Pokemon.get(selectedPokemon);
		systemMsg = "Go! " + currentPokemon.getName() + "!";
		displaySystemMsg();
	}
	
	//Generating a random name
	public String randomName() {
		String name = "";
		int random = (int)(Math.random() * 10);
		if ( random == 0 ) { name = "Andy"; }
		else if ( random == 1 ) { name = "Richard"; }
		else if ( random == 2 ) { name = "David"; }
		else if ( random == 3 ) { name = "Leo"; }
		else if ( random == 4 ) { name = "Jimmy"; }
		else if ( random == 5 ) { name = "Vicky"; }
		else if ( random == 6 ) { name = "Ashley"; }
		else if ( random == 7 ) { name = "Joy"; }
		else if ( random == 8 ) { name = "Phoebe"; }
		else if ( random == 9 ) { name = "Helen"; }
		return name;
	}
	
	//Generating a random type
	public String randomType() {
		String type = "";
		int random = (int)(Math.random() * 10);
		if ( random == 0 ) { type = "NORMAL"; }
		else if ( random == 1 ) { type = "FIRE"; }
		else if ( random == 2 ) { type = "WATER"; }
		else if ( random == 3 ) { type = "ELECTRIC"; }
		else if ( random == 4 ) { type = "GRASS"; }
		else if ( random == 5 ) { type = "ICE"; }
		else if ( random == 6 ) { type = "FIGHTING"; }
		else if ( random == 7 ) { type = "FLYING"; }
		else if ( random == 8 ) { type = "DARK"; }
		else if ( random == 9 ) { type = "STEEL"; }
		return type;
	}
	
	//~~~~~~~~~~~~~~Starting a Legendary Pokemon Battle~~~~~~~~~~~~~~
	public void legendaryBattleStart() {
		battleMode = true;
		opponentTurn = false;
		currentPokemon = new Default();
		//Spawns wild Pokemon & displays message
		enemyPokemon = new Mew();
		systemMsg = "Wild Mew appeared!";
		displaySystemMsg();
		//Player calls out first Pokemon & displays message
		selectedPokemon = 0;
		currentPokemon = _Pokemon.get(selectedPokemon);
		systemMsg = "Go get 'em, " + currentPokemon.getName() + "!";
		displaySystemMsg();
	}
	
	//Capturing pokemon
	public void capturePokemon( Pokemon p ) {
		capturedPokemon = capturedPokemon + 1;
		_Pokemon.set( capturedPokemon - 1, p );
		( _Pokemon.get( capturedPokemon - 1 ) ).setWild(false);
		Player.setPokemonLeft( Player.getPokemonLeft() + 1 );
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
		if ( enemyPokemon.getWild() == false ) { gained = enemyPokemon.getLevel() * 6; }
		else { gained = enemyPokemon.getLevel() * 4; }
		currentPokemon.gainEXP(gained);
		return gained;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~MISC DISPLAY FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
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
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PLAYING POKEMON!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void play() {
		//startup prompts; only prompts user once
		startupMsg();
		String gender = "";
		while ( !(gender.equals("boy")) && !(gender.equals("girl")) ) {
			gender = promptGender();
			gender = gender.toLowerCase();
		}
		String name = promptName();
		
		//instantiation of classes
		Player user = new Player(gender, name);
		userMap = new Map(Player.getMapNum());
		
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
		while ( user.getBadges() != 4 ) {			
			
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
				//After battle has ended: Player black out; Trainer defeated -> gain $$; Evolutions
				afterBattle();
			}
		}
		
		//Beating the game
		if ( user.getBadges() == 4 ) {
		}
	}
	
	public static void main (String[] args) {
		Game POKEMON = new Game();
		POKEMON.play();
	}
	
}
