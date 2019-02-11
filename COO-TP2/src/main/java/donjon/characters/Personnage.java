package donjon.characters;

import donjon.AdventureGame;
import donjon.room.Room;

/**
 * Class for a character
 *
 * @author Adeniss Karti
 */
public abstract class Personnage {

	protected AdventureGame game;
	protected int pv;
	protected int force;
	protected int po;
	protected String name;

	/**
	 * Constructor for character object
	 *
	 * @param pdv the point of life
	 * @param fo the strength of the character
	 * @param po the gold of the character
	 * @param name the name of the character
	 */
	public Personnage(int pdv,int fo,int po,String name){
		this.pv=pdv;
		this.force=fo;
		this.po=po;
		this.name=name;
	}

	/**
	 * Give the name of the character
	 *
	 * @return a string with the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Give the life points of the character
	 *
	 * @return an integer of the life points
	 */
	public int getPv(){
		return this.pv;
	}

	/**
	 * Give the strength of the character
	 *
	 * @return an integer of the strength
	 */
	public int getForce(){
		return this.force;
	}

	/**
	 * Give the gold of the player
	 *
	 * @return an integer of the gold
	 */
	public int getPo(){
		return this.po;
	}

	/**
	 * Give the game where the character is
	 *
	 * @return an AdventureGame
	 */
	public AdventureGame getGame(){
		return this.game;
	}

	/**
	 * Set the game for the character
	 *
	 * @param game the game to add at the character
	 */
	public void addToGame(AdventureGame game){
		this.game = game;
	}

	/**
	 * Change the value of the life point
	 *
	 * @param val the change you want to apply (negative if he loose lp or positive if he win lp)
	 */
	public void changePv(int val){
		this.pv=this.pv+val;
	}

	/**
	 * Change the value of the strength
	 *
	 * @param val the change you want to apply (negative if he loose or positive if he win)
	 */
	public void changeForce(int val){
		this.force=this.force+val;
	}

	/**
	 * Change the value of the gold
	 *
	 * @param val the change you want to apply (negative if he loose lp or positive if he win lp)
	 */
	public void changePo(int val){
		this.po=this.po+val;
	}

	/**
	 * Say if the character is dead or not
	 *
	 * @return a boolean
	 */
	public boolean isDead(){
		return (this.getPv() <= 0);
	}

	/**
	 * The character die and drop a purse on the ground
	 *
	 * @param r the room where the character dies
	 */
	public abstract void die(Room r);

	/**
	 * A toString method for characters
	 *
	 * @return a string
	 */
	public String toString(){
		return this.getName();
	}
}
