package donjon.action;

import donjon.UI.Interact;
import donjon.characters.Player;
import donjon.room.Direction;
import donjon.room.Room;

import java.util.Map;

/**
 * MoveAction class
 *
 * @see donjon.action.Action
 */
public class MoveAction extends Action {

    /**
     * Create a MoveAction object
     */
    public MoveAction(){
        super("Move");
    }

    /**
     * Return if the player can move or not
     *
     * @return a boolean
     */
    public boolean isPossible(Player p) {
        return !(p.getGame().getCurrentRoom().hasMonsters());
    }

    /**
     *  Execute the moving action
     * @param p the player who do the action
     */
    public void execute(Player p){
        Interact inter = new Interact();
        Map<Direction,Room> dir = p.getGame().getCurrentRoom().getListVoisin();
        Direction t = inter.move(dir);
        Room r = p.getGame().getCurrentRoom().getVoisin(t);
        r.generateRoom();
        p.getGame().setCurrentRoom(r);
        System.out.println("You moved to the next room");
    }
}

