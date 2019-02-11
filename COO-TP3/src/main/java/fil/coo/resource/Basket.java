package fil.coo.resource;

/**
 * Class for the baskets
 *
 * @author Adeniss KARTI
 * @see Resource
 */
public class Basket implements Resource{

    /**
     * Constructor for baskets
     */
    public Basket(){}

    /**
     * Give a description of the basket
     * @return a string
     */
    public String description() {
        return "Basket";
    }
}
