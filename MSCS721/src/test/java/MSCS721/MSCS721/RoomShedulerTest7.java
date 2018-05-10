package MSCS721.MSCS721;

import static org.junit.Assert.*;

/**
 *aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
 */

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest7 {

	@Test
	public void test() {
		Room r0 = new Room("011",4, "south", 2);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.listSchedule(rooms);
		org.junit.Assert.assertEquals("",result);
		
	}

}
