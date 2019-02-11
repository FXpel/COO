package fil.coo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fil.coo.pool.CubiclePool;
import fil.coo.resource.Cubicle;

public class CubiclePoolTest {

	protected int size ; 
	protected List <Cubicle>  available ;
	protected List <Cubicle> occupied ;
	

	@Test
	public void testProvideResource() {
		CubiclePool rp = new CubiclePool(3);
		Cubicle b = rp.getavailable().get(0);
		rp.ProvideResource();
		assertFalse(b == rp.getavailable().get(0));
		assertEquals(b,rp.getoccupied().get(0));
	}

	@Test
	public void testRecoverSource() {
		CubiclePool rp = new CubiclePool(3);
		Cubicle b = rp.getavailable().get(0);
		rp.ProvideResource();
		assertFalse(rp.getavailable().contains(b));
		assertEquals(b,rp.getoccupied().get(0));
		rp.RecoverSource(b);
		assertTrue(rp.getavailable().contains(b));
	}

	@Test
	public void testOccupiedIsEmpty() {
		CubiclePool rp = new CubiclePool(3);
		assertTrue(rp.occupiedIsEmpty());
	}

	@Test
	public void testAvailableIsEmpty() {
		CubiclePool rp = new CubiclePool(3);
		rp.ProvideResource();
		rp.ProvideResource();
		rp.ProvideResource();
		assertTrue(rp.availableIsEmpty());
	}
}
