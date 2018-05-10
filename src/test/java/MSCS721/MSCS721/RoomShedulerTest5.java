package MSCS721.MSCS721;

import static org.junit.Assert.*;

/**
 *aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
 */

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest5 {

	@Test
	public void testscheduleRoom() {
		Room r0 = new Room("011",4, "east", 2);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		r1.addRoom(rooms);
		String result = r1.scheduleRoom(rooms);
		org.junit.Assert.assertEquals("Successfully scheduled!",result);
		
	
	}

}
