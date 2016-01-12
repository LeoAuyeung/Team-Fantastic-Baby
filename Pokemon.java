//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pokemon.java
package Pokedex;

public abstract class Pokemon {
	
	//mother class governing all Pokemon in the game
	protected String name, type; //will we let type change?
	protected int currentHP, maxHP, attack, defense, speed, level;
	protected double exp;
	protected String[] weaknesses, strengths;
	protected String[] movesName;
	protected Integer[] movesDmg;
	//if move is type weak, more dmg. if move is type strength, less dmg
	
	//Constructor
	public Pokemon ( String n, int hp, int atk, int def, int spd, int lvl, String t ) {
		name = n;
		maxHP = hp;
		currentHP = maxHP;
		attack = atk;
		defense = def;
		speed = spd;
		level = lvl;
		exp = 0;
		type = t;
	}
	
	//Mutators
	public void setName ( String n ) { name = n; }
	public void setType ( String t ) { type = t; }
    public void setHP ( int hp ) { currentHP = hp;}
    public void setAttack ( int atk ) { attack = atk;}
    public void setDefense ( int def ) { defense = def;}
    public void setSpeed ( int spd ) { speed = spd;}
	public void setEXP ( double xp ) { exp = xp; }
	
	public boolean fainted() { return currentHP > 0; }
	//do we also want statuses like paralyzed, frozen, etc
	
	//Accessors
	public String getName() { return name; }
	public String getType() { return type; }
    public int getHP() { return currentHP; }
    public int getAttack() { return attack;}
    public int getDefense() { return defense;}
    public int getSpeed() { return speed;}
	public double getEXP() { return exp; }
	
	//Battle methods
	public int attack (Pokemon enemy, int move) {
		int damage = ( ( (2 * level + 10) / 250 ) * ( attack / enemy.getDefense() ) * movesDmg[move] + 2 );
		//actual formula for dmg in Pokemon
		enemy.setHP ( enemy.getHP() - damage );
		return damage;
	}
	
	//description of Pokemon
	public abstract String about();
	
}
