package donjon.item;

import donjon.characters.Personnage;

/**
 * A class for Strength potion items
 */
public class StrengthPotion extends Item {

    private int montant;

    /**
     * Create a strength potion
     *
     * @param m the power given by the potion
     * @param n the name of the potion
     */
    public StrengthPotion(int m,String n){
        super(n);
        this.montant=m;
    }

    public int getMontant(){
        return montant;
    }
    /**
     * Use the potion
     *
     * @param p the player who use the potion
     */
    public void isUsedBy(Personnage p) {
        System.out.println("You win " + this.montant + " strength points.");
        p.changeForce(this.montant);
        p.getGame().getCurrentRoom().removeItem(this);
    }
}
