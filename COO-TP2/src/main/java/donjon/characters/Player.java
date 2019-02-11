package donjon.characters;



import java.util.HashMap;

import java.util.Map;
import donjon.UI.Interact;
import donjon.action.Action;
import donjon.action.AttackAction;
import donjon.action.MoveAction;
import donjon.action.Use;
import donjon.item.Purse;
import donjon.room.Room;

/**
 * Class for the player
 *
 * @author Adeniss Karti François-Xavier Pelage
 *
 */
public class Player extends Personnage {
	private Map<String,Action> actions;
	private int nbSalleVisite;

	/**
	 * Create a player object
	 *
	 * @param pdv the number of point of life
	 * @param fo the strength points
	 * @param po the coins of the player
	 * @param name the name of the player
	 */
	public Player(int pdv, int fo, int po,String name) {
		super(pdv, fo, po,name);
		this.actions = new HashMap<String,Action>();
        this.nbSalleVisite=0;
        
        
	}
	
	/**
	 * Add an action for the player
	 *
	 * @param a an action to add
	 */
	public void addAction(Action a){
		this.actions.put(a.toString(),a);
	}

	/**
	 * Give the number of visited room
	 *
	 * @return an integer
	 */
	public int  getNbSalleVisite(){
        return this.nbSalleVisite;
    }


	/**
	 * Give an action of the player based on the list of action
	 *
	 * @param s the name of the action
	 * @return an action according to the name
	 */
	public Action getAction(String s){
		return this.actions.get(s);
	}

	/**
	 * The player do an action
	 */
	public void act(){
	Interact inter = new Interact();
	Map<String,Action> Possibleactions = new HashMap<String,Action>();
	System.out.println(Possibleactions);
	for (Map.Entry<String, Action> entry : actions.entrySet()){
		if(entry.getValue().isPossible(this)){
			Possibleactions.put(entry.getKey(), entry.getValue());
		}
	}
	String s = inter.actions(Possibleactions);
	Possibleactions.get(s).execute(this);
	}

	/**
	 * The player basic movement
     *
	 */
	public void BasicMove() {
		Action attack = new AttackAction();
		Action move = new MoveAction();
		Action use = new Use();
		this.actions.put(attack.toString(),attack);
        this.actions.put(move.toString(),move);
        this.actions.put(use.toString(),use);
    }

	/**
	 * The player die and the game is set to finish
	 */
    public void die(Room r){
		Purse p = new Purse("Purse",this.getPo());
		r.addItem(p);
		this.getGame().setEnd();
		System.out.println("Wow SUCH END");
	}
    

   
   
   
   
   
   

}
