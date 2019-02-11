package fil.coo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fil.coo.pool.BasketPool;
import fil.coo.resource.Basket;

public class BasketPoolTest {
	protected int size ; 
	protected List <Basket>  available ;
	protected List <Basket> occupied ;
	

	@Test
	public void testProvideResource() {
		BasketPool rp = new BasketPool(3);
		Basket b = rp.getavailable().get(0);
		rp.ProvideResource();
		assertFalse(b == rp.getavailable().get(0));
		assertEquals(b,rp.getoccupied().get(0));
	}

	@Test
	public void testRecoverSource() {
		BasketPool rp = new BasketPool(3);
		Basket b = rp.getavailable().get(0);
		rp.ProvideResource();
		assertFalse(rp.getavailable().contains(b));
		assertEquals(b,rp.getoccupied().get(0));
		rp.RecoverSource(b);
		assertTrue(rp.getavailable().contains(b));
	}

	@Test
	public void testOccupiedIsEmpty() {
		BasketPool rp = new BasketPool(3);
		assertTrue(rp.occupiedIsEmpty());
	}

	@Test
	public void testAvailableIsEmpty() {
		BasketPool rp = new BasketPool(3);
		rp.ProvideResource();
		rp.ProvideResource();
		rp.ProvideResource();
		assertTrue(rp.availableIsEmpty());
	}


}
