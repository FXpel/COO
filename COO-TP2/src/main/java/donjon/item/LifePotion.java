package donjon.item;

import donjon.characters.Personnage;

/**
 * A class for Life potions
 */
public class LifePotion extends Item{

	private int heal;

	/**
	 * Create a life potion item
	 *
	 * @param m the life point restored by the potion
	 * @param n the name of the potion
	 */
	public LifePotion(int m,String n){
		super(n);
		this.heal=m;
	}

	public int getHeal(){
		return this.heal;
	}

	/**
	 * Use the life potion
	 *
	 * @param p the player who use the potion
	 */
	public void isUsedBy(Personnage p) {
		System.out.println("You win " + this.heal + " life points.");
	    p.changePv(this.heal);
		p.getGame().getCurrentRoom().removeItem(this);

	}
}
