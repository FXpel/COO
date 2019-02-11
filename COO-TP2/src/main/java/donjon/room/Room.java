package donjon.room;

import java.util.*;

import donjon.characters.Monster;
import donjon.item.Item;
import donjon.item.LifePotion;
import donjon.item.OneArmedBandit;
import donjon.item.StrengthPotion;

import static donjon.room.Direction.*;

/**
 * A class for Room object
 *
 * @author Adeniss Karti François-Xavier Pelage
 */
public class Room {

	protected Map<Direction,Room> voisins;
	protected List<Monster> monsters;
	protected List<Item> items;
	protected String name;

	/**
	 * Create a room object
	 *
	 * @param name the name of the room
	 */
	public Room(String name){
        this.name = name;
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.voisins = new HashMap<Direction, Room>();
	}

	/**
	 * Generate the neigthboors
	 */
	public void generateNeigthboors(){
		Random r=new Random();
		int randomNord =r.nextInt(2);
		int randomEst=r.nextInt(2);
		int randomSud=r.nextInt(2);
		int randomOuest=r.nextInt(2);
		int randomExit= r.nextInt(90);

		;
		Direction dExit = null;
		if (randomExit>80){
			dExit = this.addExit();
		}

		if(randomOuest==1 && dExit != West){
			this.addVoisin(West,new Room("Room"));
		}
		if(randomNord==1 && dExit != North){
			this.addVoisin(North,new Room("Room"));
		}
		if(randomEst==1 && dExit != East){
			this.addVoisin(East,new Room("Room"));
		}
		if(randomSud==1 && dExit != South){
			this.addVoisin(South,new Room("Room"));
		}
		if((randomEst == 0 ) && (randomNord == 0) && (randomOuest == 0) && (randomSud ==0)){
			int randImp = r.nextInt(4);
			switch (randImp){
				case 0:
					this.addVoisin(North, new Room("Room"));
					break;
				case 1:
					this.addVoisin(South, new Room("Room"));
					break;
				case 2:
					this.addVoisin(East, new Room("Room"));
					break;
				case 3:
					this.addVoisin(West, new Room("Room"));
					break;
				default:
					this.addVoisin(North, new Room("Room"));
			}
		}
	}

	public  Map<Direction,Room> getListVoisin(){
		return this.voisins;
	}
	/**
	 * Generate the items of the room
	 */
	public void generateItems(){
		Random r = new Random();
		int itemNumber = r.nextInt(3);
		for (int i = 0; i < itemNumber; i++){
			int it = r.nextInt(3);
			int val = r.nextInt(70);
			switch (it){
				case 0:
					this.addItem(new LifePotion(val, "LifePotion"));
					break;
				case 1:
					this.addItem(new StrengthPotion(val/2, "StrengthPotion"));
					break;
				case 2:
					this.addItem(new OneArmedBandit(val,"OneArmedBandit"));
			}
		}
	}

	/**
	 * Generate the monsters of the room
	 */
	public void generateMonsters(){
		Random r = new Random();
		int monsterNumber = r.nextInt(3);
		for (int i = 0; i < monsterNumber; i++){
			int pdv = r.nextInt(75);
			int fo = r.nextInt(25);
			int po = r.nextInt(25);
			this.addMonster(new Monster(pdv,fo,po,"Monster"));
		}
	}

	/**
	 * Generate the room in general
	 */
	public void generateRoom(){
		this.generateNeigthboors();
		this.generateMonsters();
		this.generateItems();
	}

	/**
	 * Add an exit at a random direction
	 *
	 * @return the direction of the exit
	 */
	public Direction addExit() {
		Random r = new Random();
		int randEx = r.nextInt(4);
		switch (randEx){
			case 0:
				this.addVoisin(North, new Exit("Exit"));
				return North;
			case 1:
				this.addVoisin(South, new Exit("Exit"));
				return South;
			case 2:
				this.addVoisin(East, new Exit("Exit"));
				return East;
			case 3:
				this.addVoisin(West, new Exit("Exit"));
				return West;
			default:
				this.addVoisin(North, new Exit("Exit"));
				return North;
		}
	}

	/**
	 * Say if the room is an exit room or not
	 *
	 * @return a boolean false
	 */
	public boolean isExit(){
		return false;
	}

	/**
	 * Give the list of the items in the room
	 *
	 * @return an arraylist of items
	 */
	public List<Item> getItems(){
		return this.items;
	}

	/**
	 * Give the list of the monsters in the room
	 *
	 * @return an arraylist of monsters
	 */
	public List<Monster> getMonsters(){
		return this.monsters;
	}

	/**
	 * Give a list of the possible direction for the room
	 *
	 * @return an arraylist of direction
	 */
	public List<Direction> getVoisinDirection(){
	    return new ArrayList<Direction>(this.voisins.keySet());
    }

	/**
	 * Give the neigthboor in the given direction
	 *
	 * @param d the direction
	 * @return a room or null if no room for the direction
	 */
	public Room getVoisin(Direction d){
		if(this.voisins.containsKey(d)) {
            return this.voisins.get(d);
        }
        return null;
	}

	/**
	 * Add a monster in the room
	 *
	 * @param m the monster to add
	 */
	public void addMonster(Monster m){
		this.monsters.add(m);
	}

	/**
	 * Add an item in the room
	 *
	 * @param i the item to add
	 */
	public void addItem(Item i){
		this.items.add(i);
	}

	/**
	 * Add a room in the given direction
	 *
	 * @param d a direction where you want to add
	 * @param r the room to add
	 */
	public void addVoisin(Direction d,Room r){
		this.voisins.put(d,r);
	}

	/**
	 * Remove an item from the room
	 *
	 * @param i the item to remove
	 */
	public void removeItem(Item i){
		this.items.remove(i);
	}

	/**
	 * Remove a monster from the room
	 *
	 * @param m the monster to remove
	 */
	public void removeMonster(Monster m){
		this.monsters.remove(m);
	}

	/**
	 * Say if there is a monster in the room
	 *
	 * @return a boolean
	 */
	public boolean hasMonsters(){
		return !this.monsters.isEmpty();
	}

    /**
     * Say if there is an item in the room
     *
     * @return a boolean
     */
	public boolean hasItems(){
        return !this.items.isEmpty();
    }

	/**
	 * Give a description of the room
	 *
	 * @return the name, the number of items and monsters
	 */
	public String toString(){
	    return this.name + " contains : " + this.items.size() + " item(s) and " + this.monsters.size() + " monster(s)." ;
    }
}
