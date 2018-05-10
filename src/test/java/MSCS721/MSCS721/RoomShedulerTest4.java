package MSCS721.MSCS721;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 *aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
 */
public class RoomShedulerTest4 {

	@Test
	public void testListRooms() {
		Room r0 = new Room("011",4,"east", 3);
		r0.getName();
		r0.getCapacity();
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		r1.addRoom(rooms);
		String result = r1.listRooms(rooms);
		org.junit.Assert.assertEquals("1 Room(s)",result);
	  
		
		
		
	}

}
