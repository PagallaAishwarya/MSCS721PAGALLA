package MSCS721.MSCS721;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
 */


import org.junit.Test;

public class RoomShedulerTest2 {

	@Test
	public void testRemoveRoom() {
		Room r0 = new Room("011",4,"north",3);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.removeRoom(rooms);
		org.junit.Assert.assertEquals("Invalid Room",result);		
	}

}
