package fil.coo.pool;

import fil.coo.resource.Basket;

public class BasketPool extends ResourcePool<Basket> {
	
public BasketPool(int size){
	super(size);
}
protected Basket CreateResource(){
	return new Basket();
}
}	