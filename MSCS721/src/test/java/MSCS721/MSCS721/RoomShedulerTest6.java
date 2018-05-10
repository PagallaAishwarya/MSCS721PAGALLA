package MSCS721.MSCS721;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 *aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
 */
public class RoomShedulerTest6 {

	@Test
	public void testscheduleRoom() {
		Room r0 = new Room("011",4,"west",2);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.scheduleRoom(rooms);
		org.junit.Assert.assertEquals("No Room Added",result);
		
	
	}

}
