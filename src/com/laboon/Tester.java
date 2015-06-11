package com.laboon;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class Tester {

	// Unit tests for Game class
	//	"dosomething()" method in Game class	
	//	Test command S
	@Test
	public void testMoveSouth(){
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p,h);
		int returnVal = g.doSomething("S");
		verify(h,times(1)).moveSouth();
		assertEquals(returnVal,0);
	}

	//	Test command N
	@Test
	public void testMoveNorth() {
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p, h);
		int result = g.doSomething("N");
		verify(h, times(1)).moveNorth();
		verify(h, never()).moveSouth();
		assertEquals(result, 0);
	}
	
	//	Test command L
	@Test
	public void testLook(){
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p,h);
		int returnVal = g.doSomething("L");
		verify(h,times(1)).look(p,null);
		assertEquals(returnVal,0);
	}

	//	Test command I
	@Test
	public void testInventory(){
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p,h);
		int returnVal = g.doSomething("I");
		verify(p,times(1)).showInventory();
		assertEquals(returnVal,0);
	}

	//	Test command D
	@Test
	public void testDrink(){
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p,h);
		int returnVal = g.doSomething("D");
		verify(p,times(1)).drink();
		boolean finalstatus = p.drink();
		if(finalstatus){
			assertEquals(returnVal,1);
		}else{
			assertEquals(returnVal,-1);
		}	
	}

	//Unit tests for Player class
	//"hasAllItem()" method in player class
	// test if the expected result is true if a player have all 3 items
	@Test
	public void testHasAllItem(){
		Player p = new Player(true,true,true);
		boolean returnVal = p.hasAllItems();
		assertEquals(returnVal,true);
	}

	// test if the expected result is false if a player have only 2 items
	@Test
	public void testHasOnlyOneItem(){
		Player p = new Player(true,false,true);
		boolean returnVal = p.hasAllItems();
		assertEquals(returnVal,false);
	}

	// test if the expected result is false if a player have no item
	@Test
	public void testHasOnlyNoItem(){
		Player p = new Player(false,false,false);
		boolean returnVal = p.hasAllItems();
		assertEquals(returnVal,false);
	}

	//Unit tests for Player class
	//"drink()" method in player class
	// test if the expected result is false if a player have only 1 item
	@Test
	public void testDrink1(){
		Player p = new Player(true,false,false);
		boolean returnVal = p.drink();
		assertEquals(returnVal,false);		
	}
	
	// test if the expected result is false if a player have only 2 item
	@Test
	public void testDrink2(){
		Player p = new Player(true,true,false);
		boolean returnVal = p.drink();
		assertEquals(returnVal,false);		
	}
	
	// test if the expected result is true if a player have all 3 items
	@Test
	public void testDrink3(){
		Player p = new Player(true,true,true);
		boolean returnVal = p.drink();
		assertEquals(returnVal,true);		
	}

	//Unit tests for House class
	//"getcurrentRoonInfo()" method in house class

	@Test
	public void testRoomInfo() {
		Room r = mock(Room.class);
		when(r.getDescription()).thenReturn("foo");//this is stub
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms);
		String returnVal = h.getCurrentRoomInfo();
		assertEquals(returnVal, "foo");
	}

	@Test
	public void testMagicalLand() {
		Room r = mock(Room.class);
		when(r.getDescription()).thenReturn("foo");
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms);
		h.moveSouth();
		// EXECUTION STEP
		String returnVal = h.getCurrentRoomInfo();
		assertEquals(returnVal, "You are in a magical land!  But you are returned to the beginning!");
	}

	//"generateRoom()" method in house class
	@Test
	public void testGenerateNumRooms(){
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r.length, 6);
		assertEquals(r[0].hasCream(), true);
		assertEquals(r[0].southExit(), false);
	}

	@Test
	public void testFirstGeneratedRoomHasCream() {
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r[0].hasCream(), true);
	}
	@Test
	public void testThirdGeneratedRoomHasCoffee() {
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r[2].hasCoffee(), true);
	}  
	@Test
	public void testLastGeneratedRoomHasSugar() {
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r[5].hasSugar(), true);
	}
	@Test
	public void testFirstGeneratedRoomSouthNotExit() {
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r[0].southExit(), false);
	}
	@Test
	public void testLastGeneratedRoomNouthNotExit() {
		House h = new House(6);
		Room[] r = h.generateRooms(6);
		assertEquals(r[5].northExit(), false);
	}
}
