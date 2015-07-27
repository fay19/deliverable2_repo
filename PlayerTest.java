import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {


	// This tests that the play does not have any item.
	// The result from hasAllItems should return false.

	@Test
	public void testHasNoItems() {
		Player np = new Player();
		boolean result = np.hasAllItems();

		assertFalse(result);
	}


	// This tests that the play has all items.
	// The result from hasAllItems should return true.

	@Test
	public void testHasAllItems() {
		Player np = new Player(true,true,true);
		boolean result = np.hasAllItems();

		assertTrue(result);
	}


	// This tests the case that the player wins when he/she has all items and drinks.
	// The result from the method drink() should return true.		
	@Test
	public void testDrinkw() {
		Player np = new Player(true,true,true);
		boolean result = np.drink();

		assertTrue(result);
	}


	// This tests the case that the player loses when he/she has two of all items and drinks.
	// The result from the method drink() should return false.	

	@Test
	public void testDrinkl() {
		Player np = new Player(false,true,true);
		boolean result = np.drink();

		assertFalse(result);
	}


	// This tests the case that the player loses when he/she has only one of all items and drinks.
	// The result from the method drink() should return false.	

	@Test
	public void testDrinkl2() {
		Player np = new Player(false,false,true);
		boolean result = np.drink();

		assertFalse(result);
	}

}
