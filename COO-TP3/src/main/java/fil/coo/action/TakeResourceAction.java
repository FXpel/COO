package fil.coo.action;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Resource;
import fil.coo.resource.ResourceUser;

import java.util.NoSuchElementException;

import fil.coo.ActionFinishedException;

/**
 * @author pelage
 * @param <R> 
 *
 */
public class TakeResourceAction <R extends Resource> extends Action{
	protected ResourcePool<R> resourcepool;
	protected ResourceUser<R> userpool;
	/**
	 * Construct a TakeResourceAction
	 * @param resourcepool 
	 * @param userpool 
	 */
	public TakeResourceAction(ResourcePool<R> resourcepool,ResourceUser<R> userpool){
		super();
		this.resourcepool = resourcepool;
		this.userpool = userpool;
		
	}
	public boolean stopCondition() {
		return userpool.getResource()!= null;
		
	}

	@Override
	protected void stepEffect() {
		R r = null;
		try{
			r= resourcepool.ProvideResource();
			System.out.println("trying to take resource from pool "+ resourcepool.getoccupied().get(0).description() +"...sucess");
			userpool.setResource(r);
		}
		catch(NoSuchElementException e) {
			System.out.println("trying to take resource from pool "+ resourcepool.getoccupied().get(0).description() +"...failed");
		}
			
	}
}


