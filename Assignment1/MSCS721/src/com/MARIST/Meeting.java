package com.MARIST;


import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishw
 */
class Meeting {
    // initialize subject, start and stop times
        public Timestamp startTime = null;
	public Timestamp stopTime = null;
	public String subject = null;

        //method meeting 
	public Meeting(Timestamp newStartTime, Timestamp newEndTime, String newSubject) {
		setStartTime(newStartTime);
		setStopTime(newEndTime);
		if (newSubject.isEmpty()) {
			setSubject("N/A");
		}
		else {
			setSubject(newSubject);
		}
	}

    
	public String toString() {
                return this.getStartTime().toString() + " - " + this.getStopTime() + ": " + getSubject();
        }
	
	public Timestamp getStartTime() {
		return startTime;
	}

	public final void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getStopTime() {
		return stopTime;
	}

	public final void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public String getSubject() {
		return subject;
	}

	public final void setSubject(String subject) {
		this.subject = subject;
	}

}

    
