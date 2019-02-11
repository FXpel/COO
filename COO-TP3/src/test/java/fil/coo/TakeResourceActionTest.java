package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.action.FairScheduler;
import fil.coo.action.FreeResourceAction;
import fil.coo.action.TakeResourceAction;
import fil.coo.pool.BasketPool;
import fil.coo.pool.CubiclePool;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;

public class TakeResourceActionTest {

	@Test
	public void stepEffect() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(2);
		CubiclePool cubicles = new CubiclePool(2);
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		assertEquals(null,cubicleUser.getResource());
		assertEquals(null,basketUser.getResource());
		TakeResourceAction<Basket> tb = new TakeResourceAction<Basket>(baskets,basketUser);
		TakeResourceAction<Cubicle> tc = new TakeResourceAction<Cubicle>(cubicles,cubicleUser);
		
		
		
		FairScheduler s = new FairScheduler();
		s.addAction(tb);
		s.addAction(tc);
		
		s.doStep();
		// on vérfie que l'utilisateur à bien récupérer la ressource
		assertEquals(baskets.getoccupied().get(0),basketUser.getResource());
		s.doStep();
		assertEquals(cubicles.getoccupied().get(0),cubicleUser.getResource());
		
	}
	@Test
	public void stopConditionTest() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(2);
		CubiclePool cubicles = new CubiclePool(2);
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		TakeResourceAction<Basket> tb = new TakeResourceAction<Basket>(baskets,basketUser);
		TakeResourceAction<Cubicle> tc = new TakeResourceAction<Cubicle>(cubicles,cubicleUser);
		FairScheduler s = new FairScheduler();
		s.addAction(tb);
		s.addAction(tc);
		s.doStep();
		s.doStep();
	}
	
	@Test(expected = ActionFinishedException.class)
	public void stopConditionTestbad() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(2);
		CubiclePool cubicles = new CubiclePool(2);
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		TakeResourceAction<Basket> tb = new TakeResourceAction<Basket>(baskets,basketUser);
		TakeResourceAction<Cubicle> tc = new TakeResourceAction<Cubicle>(cubicles,cubicleUser);
		FairScheduler s = new FairScheduler();
		s.addAction(tb);
		s.addAction(tb);
		s.addAction(tc);
		s.addAction(tc);
		s.doStep();
		s.doStep();
		s.doStep();
		s.doStep();
	}	
}
