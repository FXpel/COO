package fil.coo.action;

import fil.coo.ActionFinishedException;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Resource;
import fil.coo.resource.ResourceUser;

/**
 * @author pelage & Karti
 * @param <R> 
 *
 */
public class FreeResourceAction <R extends Resource> extends Action {
	
	protected ResourcePool<R> resourcepool;
	protected ResourceUser<R> userpool;
	/**
	 * Construct a TakeResourceAction
	 * @param resourcepool 
	 * @param userpool 
	 */
	public FreeResourceAction(ResourcePool<R> resourcepool,ResourceUser<R> userpool){
		super();
		this.resourcepool = resourcepool;
		this.userpool = userpool;
	}
	@Override
	public boolean stopCondition() {
		return userpool.getResource() == null;
	}

	@Override
	protected void stepEffect() {
		System.out.println(userpool.getName()+"freeing resource from "+ resourcepool.getoccupied().get(0).description() );

		resourcepool.RecoverSource(userpool.getResource());
		userpool.resetResource();
		

	}

}
