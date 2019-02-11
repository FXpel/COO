package donjon.item;

import donjon.UI.Interact;
import donjon.characters.Personnage;

import java.util.Random;

/**
 * A class for the "Bandit manchot"
 */
public class OneArmedBandit extends Item{

    private int cost;

    /**
     * Create a one armed bandit
     *
     * @param cost the cost to produce the effect
     * @param name the name of the guy
     */
    public OneArmedBandit(int cost, String name){
        super(name);
        this.cost= cost;
    }

    /**
     * Return the cost of the item
     *
     * @return an integer
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * Use the one armed bandit item
     *
     * @param p the player using the item
     */
    public void isUsedBy(Personnage p){
        Interact i = new Interact();
        boolean use = i.interBandit(p.getPo(), this.getCost());
        if (use){
            Item randItem = this.createRanditem();
            randItem.isUsedBy(p);
        }
        p.getGame().getCurrentRoom().removeItem(this);

    }

    /**
     * Create a lifePotion or a strengthPotion with a random value
     *
     * @return the created item
     */
    private Item createRanditem() {
        Random r = new Random();
        int it = r.nextInt(1);
        int porn = r.nextInt(2);
        int val = r.nextInt(50);

        if (porn == 0){
            val = -val;
        }

        switch (it){
            case 0:
                return new LifePotion(val, "LifePotion");
            case 1:
                return new StrengthPotion(val, "StrengthPotion");
            default:
                return new Purse("Purse",val);
        }
    }
}
