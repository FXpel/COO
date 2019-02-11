package fil.coo.resource;

/**
 * Class for resource user
 *
 * @author Adeniss KARTI & Pelage
 * @param <R> 
 * @see Resource
 */
public class ResourceUser<R extends Resource> {

    protected R resource;
    protected String name;

    /**
     * @param name
     */
    public ResourceUser(String name){
        this.name = name;
        this.resource = null;
    }

    /**
     * A method to get the resource of the user
     * @return the resource used
     */
    public R getResource(){
        return resource;
    }

    /**
     * Set the resource for the user
     * @param resource the resource to set
     */
    public void setResource(R resource){
        this.resource = resource;
    }

    /**
     * Reset the resource of the user
     */
    public void resetResource(){
        this.resource = null;
    }

    /**
     * Give the name of the user
     * @return a string whit the name
     */
    public String getName(){
        return this.name;
    }
    

}
