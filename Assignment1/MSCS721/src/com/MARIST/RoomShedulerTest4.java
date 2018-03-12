package com.MARIST;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest4 {

	@Test
	public void testListRooms() {
		Room r0 = new Room("011",4);
		r0.getName();
		r0.getCapacity();
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		r1.addRoom(rooms);
		String result = r1.listRooms(rooms);
		org.junit.Assert.assertEquals("1 Room(s)",result);
	  
		
		
		
	}

}
