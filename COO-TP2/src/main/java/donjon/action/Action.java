package donjon.action;

import donjon.characters.Player;

/**
 * Abstract class for action
 */
public abstract class Action {

    protected String descrip;

    /**
     * Create an action object
     *
     * @param des the description of the action
     */
    public Action(String des) {
        this.descrip = des;
    }

    /**
     * Return if the action is possible or not
     *
     * @param p the player who wants to do an action
     * @return a boolean
     */
	public abstract boolean isPossible(Player p);

    /** Give the description of the action
     *
     * @return a string
     */
    public String toString(){
        return this.descrip;
    }

    /**
     * Execute the action
     *
     * @param p the player who execute the action
     */
    public abstract void execute(Player p);
}
