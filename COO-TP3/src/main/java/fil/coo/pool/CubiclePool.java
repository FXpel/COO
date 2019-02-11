package fil.coo.pool;

import fil.coo.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle> {
	
public CubiclePool(int size){
	super(size);
}
protected Cubicle CreateResource(){
	return new Cubicle();
}
}	