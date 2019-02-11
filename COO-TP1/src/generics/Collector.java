package generics;
import java.util.*;

/** define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {
    /**Create a Collector object
     *
     * @param name the name of the collector
     */
    public Collector(String name) {
	this.name = name;
    }

    private String name;
	private T carriedObject; // ATTRIBUTS carriedObject à DEFINIR

    /** Give the name of the collector
     *
     * @return a string
     */
    public String toString() {
	return this.name;
    }

    /**Give a description of the collector
     *
     * @return a string whit the name and the carried object
     */
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }


    // METHODES a DEFINIR
    // take : pour prendre un objet de type T (si aucun de "tenu")
    // getCarriedObject : pour connaitre l'objet "porte" (null si saucun)
    // giveTo : donne l'objet porte a un autre ramasseur compatible
    // drop : depose l'objet "tenu"

    /** Take the object given in parameter
     *
     * @param object The object to give
     * @throws AlreadyCarryingException
     */
    public void take(T object) throws AlreadyCarryingException{
        if(this.carriedObject != null){
            throw new AlreadyCarryingException();
        }
        else{
            this.carriedObject = object;
        }
    }

    /** Give the object carried by the collector
     *
     * @return the carried object
     */
    public T getCarriedObject(){
        return this.carriedObject;
    }

    /**Drop the object on the floor
     *
     * @return null if nothing carried or the object
     */
    public T drop(){
        if(this.getCarriedObject() == null){
            return null;
        }
        else{
            T obj = this.getCarriedObject();
            this.carriedObject = null;
            return obj;
        }
    }

    /**Give the object if the other collector have the same type and don't carry an object
     *
     * @param coll the collector who you give the object
     * @throws AlreadyCarryingException
     */
    public void giveTo(Collector<? super T> coll) throws AlreadyCarryingException{
        if(coll.getCarriedObject() != null){
            throw new AlreadyCarryingException();
        }
        else {
            T obj = this.drop();
            coll.take(obj);
        }
    }

    public static void main(String[] args) {

		Carrot c1 = new Carrot(1);
		Carrot c2 = new Carrot(2);
		Carrot c3 = new Carrot(3);
		Apple p1 = new Apple(1);
		Apple p2 = new Apple(2);

		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");

		// attention ici le type d'objets ramasses est Legume :
		Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

		carrotCollector1.take(c3);
		System.out.println(carrotCollector1.description());
		// NE COMPILE PAS
		// carrotCollector2.take(p1);

		// NE COMPILE PAS
		// carrotCollector1.giveTo(appleCollector1);

		// COMPILE :
		carrotCollector1.giveTo(vegetableCollector);

		// NE COMPILE PAS
		// vegetableCollector.giveTo(carrotCollector1);
		// NE COMPILE PAS
		// appleCollector1.giveTo(vegetableCollector);

		carrotCollector1.take(c1);
		carrotCollector1.giveTo(carrotCollector2);
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		carrotCollector1.take(c2);


		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (AlreadyCarryingException e) {
			//System.out.println("*** exception : " + carrotCollector2 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}

		appleCollector1.take(p2);
		System.out.println(appleCollector1.description());
		try {
			appleCollector1.take(p1);
		} catch (AlreadyCarryingException e) {
			//System.out.println("*** exception : " + appleCollector1 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}
		appleCollector1.drop();
		System.out.println(appleCollector1.description());
		appleCollector1.take(p1);

     }
}
