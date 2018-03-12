package com.MARIST;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest6 {

	@Test
	public void testscheduleRoom() {
		Room r0 = new Room("011",4);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.scheduleRoom(rooms);
		org.junit.Assert.assertEquals("No Room Added",result);
		
	
	}

}
