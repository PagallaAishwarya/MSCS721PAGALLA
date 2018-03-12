package com.MARIST;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomShedulerTest8 {

	@Test
	public void testimportRooms() {
		Room r0 = new Room("011",4);
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomSheduler r1 = new RoomSheduler();
		String result = r1.importRooms(rooms);
		org.junit.Assert.assertEquals("success",result);
	}
}
