package fil.coo.action;

import fil.coo.ActionFinishedException;
import fil.coo.SchedulerStartedException;
import fil.coo.pool.BasketPool;
import fil.coo.pool.CubiclePool;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;

public class Swimmer extends SequentialScheduler {
	private String name;
	private BasketPool baskets;
	private CubiclePool cubicles;
	private int undressingtime;
	private int swimmingtime;
	private int dressingtime;
	
	public Swimmer(String name,BasketPool baskets, CubiclePool cubicles,int undressingtime,int swimmingtime, int dressingtime) throws ActionFinishedException, SchedulerStartedException{
		super();
		this.name = name;
		this.baskets = baskets;
		this.cubicles = cubicles;
		this.undressingtime = undressingtime;
		this.swimmingtime = swimmingtime;
		this.dressingtime = dressingtime;
		this.init();
	}
	protected void init() throws ActionFinishedException, SchedulerStartedException {
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		//prendre un panier
		this.addAction(new TakeResourceAction<Basket>(baskets, basketUser));
		//aller dans une cabine
		this.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
		//se déshabiller
		this.addAction(new GettingUndressed(undressingtime));
		//libérer la cabine
		this.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
		//nager
		this.addAction(new Swim(swimmingtime));
		//aller dans une cabine
		this.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
		//s'habiller
		this.addAction(new GettingDressed(dressingtime));
		//libérer la cabine
		this.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
		//rendre le panier
		this.addAction(new FreeResourceAction<Basket>(baskets, basketUser));
	}
	
	protected void stepEffect() {
		try {
			
			Action a = this.nextAction();
			System.out.println(this.name + "'s turn...");
			a.doStep();
			
		} catch (ActionFinishedException e) {
			//e
		}
	}
}
