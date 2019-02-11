package donjon.action;

import donjon.UI.Interact;
import donjon.characters.*;

import java.util.List;

/**
 * AttackAction class
 *
 * @see donjon.action.Action
 */
public class AttackAction extends Action {

    /**
     * Create a AttackAction object
     */
    public AttackAction(){
        super("Attack");
    }

    /** Execute the attack on the target
     *
     * @param p the player who do the action
     */
    public void execute(Player p){
        Interact inter = new Interact();
        List<Monster> mons = p.getGame().getCurrentRoom().getMonsters();
        int sr = inter.attack(mons);
        Monster target = mons.get(sr);
        p.changePv(-(target.getForce()));
        System.out.println("Your life point : " + p.getPv());
        target.changePv(-(p.getForce()));
        System.out.println("Monter's life point : " + target.getPv());
        if (p.isDead()){
            p.die(p.getGame().getCurrentRoom());
        }
        if (target.isDead()){
            target.die(p.getGame().getCurrentRoom());
        }
    }

    /** Return if the action is possible
     *
     * @return a boolean
     */
    public boolean isPossible(Player p) {
        return p.getGame().getCurrentRoom().hasMonsters();
    }
}
