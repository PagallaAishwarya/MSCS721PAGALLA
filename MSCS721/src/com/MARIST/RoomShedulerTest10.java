package com.Marist;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest10 {

	@Test
	public void testexportSchedule() {
		Room r0 = new Room("011",0, "west", 4);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.exportSchedule(rooms);
		org.junit.Assert.assertEquals("Success",result);
		
		
		
		
	}

}
