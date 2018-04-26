package com.Marist;


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
    private String location;
    private int building;
	private int capacity;
	private ArrayList<Meeting> meetings;
	
//	
	public Room(String newName, int newCapacity, String newLocation, int newBuilding) {
		setName(newName);
		setCapacity(newCapacity);
		setMeetings(new ArrayList<Meeting>());
		setLocation(newLocation);
		setBuilding(newBuilding);
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	
}
    

