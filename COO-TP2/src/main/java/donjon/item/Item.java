package donjon.item;

import donjon.characters.Personnage;

/**
 * Class for abstract class for Items
 */
public abstract class Item{

    private String name;

    /**
     * Create a item object
     *
     * @param name the name of the object
     */
	public Item(String name){
	    this.name = name;
    }

    /**
     * Give a string to describe the item
     *
     * @return a string the name
     */
    public String toString() {
        return this.name;
    }

    /**
     * Abstract method to useItem
     *
     * @param p the character who use the item
     */
    public abstract void isUsedBy(Personnage p);

}