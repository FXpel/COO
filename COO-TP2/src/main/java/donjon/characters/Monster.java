package donjon.characters;
import donjon.item.Purse;
import donjon.room.*;

/**
 * A class for Monsters
 */
public class Monster extends Personnage {

	/**
	 * Create a Monster object
	 * @param pdv the life point of the monster
	 * @param fo the strength of the monster
	 * @param po the golds of the monster
	 * @param name the name of the monster
	 */
	public Monster(int pdv, int fo, int po,String name) {
		super(pdv, fo, po,name);
	}

	/**
	 * The monster die add drop a purse
	 * @param current the current Room
	 */
	public void die(Room current) {
		Purse p = new Purse("MONSTER PURSE", this.po);
		current.addItem(p);
		current.removeMonster(this);
	}



}
