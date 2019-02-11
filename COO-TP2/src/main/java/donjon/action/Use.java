package donjon.action;

import donjon.UI.Interact;
import donjon.characters.Player;
import donjon.item.Item;

import java.util.List;

/**
 * UseAction class
 *
 * @see donjon.action.Action
 */
public class Use extends Action {

    /**
     * Create a Use action object
     */
    public Use(){
        super("Use");
    }

    /** Return if the player can do a use action or not
     *
     * @return a boolean
     */
    public boolean isPossible(Player p) {
        return p.getGame().getCurrentRoom().hasItems();
	}

    /** Execute the use action for the player
     *
     * @param p the player who do the action
     */
    public void execute(Player p){
        Interact inter = new Interact();
        List<Item> it = p.getGame().getCurrentRoom().getItems();
        int su = inter.use(it);
        Item i = it.get(su);
        i.isUsedBy(p);
    }
}
