
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishw
 */
class Room {
    private String name;
	private int capacity;
	private ArrayList<Meeting> meetings;
	
//	
	public Room(String newName, int newCapacity) {
		setName(newName);
		setCapacity(newCapacity);
		setMeetings(new ArrayList<Meeting>());
	}
//
	public void addMeeting(Meeting newMeeting) {
		this.getMeetings().add(newMeeting);
	}
//set name of the room 
	public String getName() {
		return name;
	}

//set name of the room ( string )
	public void setName(String name) {
		this.name = name;
	}

//  get capacity
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}


	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
	
}
    

