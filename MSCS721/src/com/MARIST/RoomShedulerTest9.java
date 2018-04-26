package com.Marist;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest9 {

	@Test
	public void testexportRooms() {
		Room r0 = new Room("011",4,"east",2);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.exportRooms(rooms);
		org.junit.Assert.assertEquals("Success",result);		

	}

}
