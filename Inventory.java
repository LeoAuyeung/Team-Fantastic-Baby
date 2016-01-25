//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Inventory.java

import java.util.ArrayList;

public class Inventory {
	
	private Integer[] pokeballs = {5, 0, 0, 0};
	private Integer[] potions = {0, 0, 0, 0, 0, 0};
	private Integer[] battleItems = {0, 0};
	private ArrayList keyItems = new ArrayList();
	
	//Mutators
	public void setPokeball ( int index, int num ) { pokeballs[index] = num; }
	public void setPotion ( int index, int num ) { potions[index] = num; }
	public void setBattleItem ( int index, int num ) { battleItems[index] = num; }
	
	public void addKeyItem ( String item ) { keyItems.add( item ); }
	
	//Accessors
	public int getPokeball ( int index ) { return pokeballs[index]; }
	public int getPotion ( int index ) { return potions[index]; }
	public int getBattleItem ( int index ) { return battleItems[index]; }
	
	public boolean hasKeyItem ( String item ) {
		for ( int i = 0; i < keyItems.size(); i++ ) {
			if ( (keyItems.get(i)).equals( item ) ) { return true; }
		}
		return false;
	}
	
	public void lowerAmount ( int item, int index ) {
		if ( item == 0 ) { //Lower Pokeballs
			setPokeball ( index, getPokeball(index) - 1 );
		}
		else if ( item == 1 ) { //Lower Potions
			setPotion ( index, getPotion(index) - 1 );
		}
		else if ( item == 2 ) { //Lower BattleItems
			setBattleItem ( index, getBattleItem(index) - 1 );
		}
	}
	
	public void addAmount ( int item, int index, int num ) {
		if ( item == 0 ) { //Add Pokeballs
			setPokeball ( index, getPokeball(index) + num );
			if ( getPokeball(index) > 999 ) { setPokeball ( index, 999 ); }
		}
		else if ( item == 1 ) { //Add Potions
			setPotion ( index, getPotion(index) + num );
			if ( getPotion(index) > 999 ) { setPotion ( index, 999 ); }
		}
		else if ( item == 2 ) { //Add BattleItems
			setBattleItem ( index, getBattleItem(index) + num );
			if ( getBattleItem(index) > 999 ) { setBattleItem ( index, 999 ); }
		}
	}
	
}
