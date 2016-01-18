//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pokemon.java
package Pokedex;

public abstract class Pokemon {
	
    //mother class governing all Pokemon in the game
    protected boolean wild; //boolean for if pkmn is wild or a Trainer's
    protected String name, type;
    protected int HP, maxHP, attack, baseAttack, defense, baseDefense, speed, level, exp, levelEXP;
    protected String[] weaknesses, strengths;
    protected int movesNum;
    protected String[] movesName = {"A","B","C","D"}; // FOR TESTING 
    protected Integer[] movesDmg;
    protected Integer[] currentPP = {20,30,40,8};
    protected Integer[] maxPP = {20,30,40,8};
	
    //Constructor
    public Pokemon() {
	name = "None";
	maxHP = 0;
	HP = 0;
	level = 0;
	type = "None";
    }
	
    public Pokemon ( String n, int hp, int atk, int def, int spd, int lvl, int e, String t ) {
	name = n;
	maxHP = hp;
	HP = maxHP;
	attack = atk;
	baseAttack = atk;
	defense = def;
	baseDefense = def;
	speed = spd;
	level = lvl;
	exp = 0;
	levelEXP = e;
	type = t;
    }
	
    //Mutators
    public void setWild ( boolean w ) { wild = w; }
    public void setName ( String n ) { name = n; }
    public void setType ( String t ) { type = t; }
    public void setHP ( int hp ) { HP = hp; }
    public void setMaxHP ( int hp ) { maxHP = hp; }
    public void setAttack ( int atk ) { attack = atk; }
    public void setDefense ( int def ) { defense = def; }
    public void setSpeed ( int spd ) { speed = spd; }
    public void setLevel ( int lvl ) { level = lvl; }
    public void setLevelEXP ( int lvlxp ) { levelEXP = lvlxp; }
    public void setEXP ( int xp ) { exp = xp; }
    public void setMoves ( int mvs ) { movesNum = mvs; }
	
    public boolean fainted() { return HP > 0; }
	
    //Accessors
    public boolean getWild() { return wild; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public int getLevel() { return level; }
    public int getLevelEXP() { return levelEXP; }
    public int getEXP() { return exp; }
    public int getMovesNum() { return movesNum; }
    public String getMovesName( int n ) { return movesName[n]; }
    public int getCurrentPP( int n ) { return currentPP[n]; }
    public int getMaxPP( int n ) { return maxPP[n]; }
	
    //Battle methods
	public int attack (Pokemon enemy, int n) {
	int move = n - 1;
	double effectiveness = 1;
	/*if ( weaknesses.contains( enemy.getType() ) ) { effectiveness = 0.5; }
	  else if ( strengths.contains( enemy.getType() ) ) { effectiveness = 2; }*/
	int baseDmg = movesDmg[move];
	int damageDealt = (int) ( ( ( (2 * getLevel() + 10) / 250 ) * ( getAttack() / enemy.getDefense() ) * baseDmg + 2 ) * effectiveness );
	//actual formula for dmg in Pokemon; http://bulbapedia.bulbagarden.net/wiki/Damage#Damage_formula
	enemy.lowerHP(damageDealt);
	currentPP[move] -= 1;
		
	return damageDealt;
    }
	
    public void normalize() {
	attack = baseAttack;
	defense = baseDefense;
    }
	
    public void restoreHP( int amount ) {
	setHP ( HP + amount );
	if ( HP > maxHP ) { HP = maxHP; }
    }
	
    public void lowerHP( int amount ) {
	setHP ( HP - amount );
	if ( HP < 0 ) { HP = 0; }
    }
	
    public void restorePP( int amount ) {
	for ( int i = 0; i < movesNum; i++ ) {
	    currentPP[i] = currentPP[i] + amount;
	    if ( currentPP[i] > maxPP[i] ) { currentPP[i] = maxPP[i]; }
	}
    }
	
    public boolean allMaxPP() {
	for ( int i = 0; i < movesNum; i++ ) {
	    if ( currentPP[i] < maxPP[i] ) { return false; }
	}
	return true;
    }
	
    //description of Pokemon
    public abstract String about();
	
}

