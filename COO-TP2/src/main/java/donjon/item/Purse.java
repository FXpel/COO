package donjon.item;

import donjon.characters.Personnage;

/**
 * A class for the purse item
 */
public class Purse extends Item {

	private int gold;

	/**
	 * Create a purse object
	 *
	 * @param name the name of the purse
	 * @param po the golds in the purse
	 */
	public Purse(String name,int po){
	    super(name);
		this.gold=po;
	}

	/**
	 * Use the purse ( the character take the golds)
	 *
	 * @param p the player who use the purse
	 */
	public void isUsedBy(Personnage p){
		System.out.println("You win " + this.gold + " golds.");
		p.changePo(this.gold);
		p.getGame().getCurrentRoom().removeItem(this);
	}

}
