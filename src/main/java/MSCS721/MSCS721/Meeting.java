package MSCS721.MSCS721;


import java.sql.Timestamp;



/**
 * aish, 1.0
 *  Pagalla (p) 1.0
 *   All rights reversed....
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

    
