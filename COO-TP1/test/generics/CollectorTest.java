import static org.junit.Assert.*;
import org.junit.*;
import generics.*;

public class CollectorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Collector<Fruit> a= new Collector<Fruit>("Jambon");
		Fruit f = new Apple(5);
	}


	@Test
	public void toStringtest(){
		Collector<Fruit> a= new Collector<Fruit>("Jambon");
		assertEquals(a.toString(),"Jambon");
	}


	@Test
	public void descriptionTest(){
		Collector<Fruit> a= new Collector<Fruit>("Jambon");
		Fruit f = new Apple(5);
		a.take(f);
		assertEquals(a.description(),"Jambon carries Apple-5");
	}
	@Test
	public void takeTest(){
		Collector<Fruit> a = new Collector<Fruit>("Jambon");
		Fruit f = new Apple(5);
		assertEquals(a.getCarriedObject(),null);
		a.take(f);
		assertEquals(a.getCarriedObject(),f);



	}

	@Test
	public void dropTest(){
		Collector<Fruit> a = new Collector<Fruit>("Jambon");
		Fruit f = new Apple(5);

		assertEquals(a.drop(),null);
		a.take(f);
		assertEquals(a.drop(),f);
	}

	@Test(expected=AlreadyCarryingException.class)
	public void giveToCollectorTest(){
		Collector<Fruit> a = new Collector<Fruit>("Jambon");
		Collector<Fruit> b = new Collector<Fruit>("Frommage");
		Fruit f1 = new Apple(5);
		Fruit f2 = new Apple(1);

		a.take(f1);
		a.giveTo(b);
		assertEquals(b.getCarriedObject(),f1);
		a.take(f2);
		b.giveTo(a);

	}

	// ---Pour permettre l'exécution des test----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CollectorTest.class);
	}

}
