package donjon;

import donjon.characters.Player;
import donjon.room.Room;

public class AdventureGame {
	private Room currentRoom;
	private boolean end;

    /**
     * Create an Adventure gmae object
     *
     * @param startingRoom the first room
     */
	public AdventureGame(Room startingRoom){
        this.currentRoom = startingRoom;
		this.end = false;
	}

    /**
     * Give the current room for the game
     *
     * @return the current room
     */
	public Room getCurrentRoom(){
		return this.currentRoom;
	}


    /**
     * Change the current room for the game
     *
     * @param r the new current room
     */
	public void setCurrentRoom(Room r){
		this.currentRoom = r;
	}

	/**
	 * End the game
	 */
	public void setEnd(){
		this.end = true;
	}

	/**
	 * Say if the game is finish or not
	 *
	 * @return a boolean
	 */
	public boolean isTheEnd(){
		return this.end;
	}

	/**
	 * Print a resume of the player
	 *
	 * @param p the player to recap
	 */
	public void recapPlayer(Player p){
		System.out.println("");
		System.out.println("----------------------------------------------");
		System.out.println(p.getName() + ", you have :");
		System.out.println(" - " + p.getPv() + " life points");
		System.out.println(" - " + p.getForce() + " strength points");
		System.out.println(" - " + p.getPo() + " golds");
		System.out.println("You have visited " + p.getNbSalleVisite() + " rooms");
		System.out.println("----------------------------------------------");
		System.out.println("");
	}



    /**
     * Lauch the game
	 *
	 * @param p the player who play the game
     */
    public void play(Player p){
		while(!this.isTheEnd()){
			this.recapPlayer(p);
			p.act();
			if (this.getCurrentRoom().isExit()){
				this.setEnd();
				System.out.println("Congratulation, you find the EXIT !");
			}
		}
		System.out.println("The Game is finished.");
	}
}
