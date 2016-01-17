//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pokemon.java
package Pokedex;

public abstract class Pokemon {
	
    //mother class governing all Pokemon in the game
    protected boolean wild; //boolean for if pkmn is wild or a Trainer's
    protected String name, type;
    protected int currentHP, maxHP, attack, defense, speed, level, exp, levelEXP;
    protected String[] weaknesses, strengths;
    protected String[] movesName;
    protected Integer[] movesDmg, currentPP, maxPP;
    //if move is type weak, more dmg. if move is type strength, less dmg
	
    //Constructor
    public Pokemon() {
	name = "None";
	maxHP = 0;
	currentHP = 0;
	level = 0;
	type = "None";
    }
	
    public Pokemon ( String n, int hp, int atk, int def, int spd, int lvl, int e, String t ) {
	name = n;
	maxHP = hp;
	currentHP = maxHP;
	attack = atk;
	defense = def;
	speed = spd;
	level = lvl;
	levelEXP = e;
	exp = 0;
	type = t;
    }
	
    //Mutators
    public void setWild ( boolean w ) { wild = w; }
    public void setName ( String n ) { name = n; }
    public void setType ( String t ) { type = t; }
    public void setCurrentHP ( int hp ) { currentHP = hp; }
    public void setMaxHP ( int hp ) { maxHP = hp; }
    public void setAttack ( int atk ) { attack = atk; }
    public void setDefense ( int def ) { defense = def; }
    public void setSpeed ( int spd ) { speed = spd; }
    public void setLevel ( int lvl ) { level = lvl; }
    public void setLevelEXP ( int lvlxp ) { levelEXP = lvlxp; }
    public void setEXP ( int xp ) { exp = xp; }
	
    public boolean fainted() { return currentHP > 0; }
	
    //Accessors
    public boolean getWild() { return wild; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public int getLevel() { return level; }
    public int getLevelEXP() { return levelEXP; }
    public int getEXP() { return exp; }
	
    //Battle methods
    public int attack (Pokemon enemy, int n) {
		
	int move = n - 1;
	double effectiveness = 1;
	/*if ( weaknesses.contains( enemy.getType() ) ) { effectiveness = 0.5; }
	  else if ( strengths.contains( enemy.getType() ) ) { effectiveness = 2; }*/
	int baseDmg = movesDmg[move];
	int damageDealt = (int) ( ( ( (2 * level + 10) / 250 ) * ( attack / enemy.getDefense() ) * baseDmg + 2 ) * effectiveness );
	//actual formula for dmg in Pokemon; http://bulbapedia.bulbagarden.net/wiki/Damage#Damage_formula
	enemy.setCurrentHP ( enemy.getCurrentHP() - damageDealt );
	currentPP[move] -= 1;
		
	return damageDealt;
    }
	
    //description of Pokemon
    public abstract String about();
	
}

