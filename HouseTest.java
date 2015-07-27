import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class HouseTest {

	// This will eventually check descriptions. 
	// Doubling object Room,  
	// Stubbing the method getDescription() and assume it returns string "TEST",
	// The result from the method getCurrentRoomInfo() will equal the string "TEST".	

	@Test
	public void testGetDescription() {
		Room r=mock(Room.class);
		when(r.getDescription()).thenReturn("TEST");
		Room[] rooms= new Room[1];
		rooms[0]=r;
		House h= new House(rooms);
		String result = h.getCurrentRoomInfo();
		assertEquals(result,"TEST");

	}


	// This tests the case that currentroom is out of the range [0,numrooms].
	// Having currentroom = -1 by calling the method moveSouth(),
	// The result from the method getCurrentRoomInfo() will equal the string: 
	// "You are in a magical land!  But you are returned to the beginning!".

	@Test
	public void testOutofRoomnum() {

		Room[] rooms= new Room[1];
		House h= new House(rooms);
		h.moveSouth();
		String pts = "You cannot go south, you are at the southest room, enter N to go north";
		String result = h.getCurrentRoomInfo();
		assertEquals(result, pts);

	}


	// This tests that cream is in the first room (room[0]).
	// The result from the method hasCream should be true.

	@Test
	public void testGenerateRooms1() {
		House h= new House(6);
		Room [] result = h.generateRooms(6);
		Room r = result[0];
		boolean cr = r.hasCream();

		assertTrue(cr);
	}


	// This tests that the last room (room[5]) does not have a north exit.
	// The result from the method northExit should be false.	

	@Test
	public void testGenerateRooms2() {
		House h= new House(6);
		Room [] result = h.generateRooms(6);
		Room r = result[5];
		boolean nd = r.northExit();

		assertFalse(nd);
	}


	// This tests that coffee is in the third room (room[2]). 
	// The result from the method hasCoffee should be true.	

	@Test
	public void testGenerateRooms3() {
		House h= new House(6);
		Room [] result = h.generateRooms(6);
		Room r = result[2];
		boolean cf = r.hasCoffee();

		assertTrue(cf);
	}

}
