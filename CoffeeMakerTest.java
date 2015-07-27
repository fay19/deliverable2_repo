import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CoffeeMakerTest {
	
	//Doubling the objects: Player and House,
	// This tests that runArgs always returns 0.
	@Test
	public void testRunArgs() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);
		int result = cm.runArgs("foo");		
		assertEquals(result, 0);
	}

	// Typing "N", the player should go north.
	// Doubling the objects: Player and House,
	// verifying the moveNorth method on the mock object House should be called once.
	// The result from the method doSomething("N") should equal 0.

	@Test
	public void testMoveNorth() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);
		int result = cm.doSomething("N");
		verify(h,times(1)).moveNorth();
		assertEquals(result,0);
	}

	// Typing "l" or "L", the player should go look for items in the current room.
	// Doubling the objects: Player and House,
	// verifying the look method on the mock object House should be called once.
	// The result from the method doSomething("l") should equal 0.

	@Test
	public void testMovetoLook() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);
		int result = cm.doSomething("l");
		verify(h,times(1)).look(p,null);
		assertEquals(result,0);
	}


	// Typing "D" or "d", the player should go drink.
	// Doubling the objects: Player and House
	// Stubbing the method drink and assuming it always returns boolean value true.
	// verifying the drink method on the mock object Player should be called once.	
	// the result from the method doSomething("D") should equal 1.

	@Test
	public void testMovetoDrink() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);
		when(p.drink()).thenReturn(true);
		int result = cm.doSomething("D");
		verify(p,times(1)).drink();
		assertEquals(result,1);
	}

	// Typing "H" or "h", possible commands should be displayed.
	// Doubling the objects: Player and House		
	// the result from the method doSomething("H") should equal 0.

	@Test
	public void testMovetoHelp() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);
		int result = cm.doSomething("H");
		assertEquals(result,0);
	}


	// Typing commands out of the instruction list, 
	// message "what?" should be printed out.
	// The result from the method doSomething("a") should equal 0.	

	@Test
	public void testElseComm() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		CoffeeMaker cm = new CoffeeMaker(p,h);

		int result = cm.doSomething("a");

		assertEquals(result,0);
	}

}
