
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishw
 */
public class RoomSheduler {
    	protected static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		Boolean end = false;
		ArrayList<Room> rooms = new ArrayList<>();
                
                //Calling methods using switch case
                //fixme :default case

		while (!end) {
                
			switch (mainMenu()) {

			case 1:
				System.out.println(addRoom(rooms));
				break;
			case 2:
				System.out.println(removeRoom(rooms));
				break;
			case 3:
				System.out.print(scheduleRoom(rooms));
				break;
			case 4:
				System.out.println(listSchedule(rooms));
				break;
			case 5:
				System.out.println(listRooms(rooms));
				break;
                        case 6:
				System.out.println(exportRooms(rooms));
				break;
			case 7:
				System.out.println(exportSchedule(rooms));
				break;
			case 8:
				System.out.println(importRooms(rooms));
				break;
			case 9:
				System.out.println(importSchedule(rooms));
				break;
                        default:
                            System.out.println("no such parameter");
			}
		}
	}
        
        //Method list schedule -lists Scheduled Rooms
        /*nullpoint exception could occur
	TODO
	FIXME null point exception
	*/
	
	protected static String listSchedule(ArrayList<Room> roomList) {
		String roomName = getRoomName();
		System.out.println(roomName + " Schedule");
		System.out.println("---------------------");
		
		if (getRoomFromName(roomList, roomName).getMeetings().size() > 0) {
			for (Meeting m : getRoomFromName(roomList, roomName).getMeetings()) {
				return m.toString();
			}
		} else {
			return "No such Scheduled  room: ";
		}
                return "";
	}
        //method mainMenu        
	protected static int mainMenu() {
                System.out.println("\nWelcome");
		System.out.println("Main Menu:");
		System.out.println("  1 - Add a room");
		System.out.println("  2 - Remove a room");
		System.out.println("  3 - Schedule a room");
		System.out.println("  4 - List Schedule");
		System.out.println("  5 - List Rooms");
                System.out.println("  6 - Export Roomdata");
                System.out.println("  7 - Export SheduleData");
                System.out.println("  8 - Import RoomsData");
                System.out.println("  9 - Import ScheduleData");
                
		System.out.println("Enter your selection: ");

		return keyboard.nextInt();
	}
//addRoom adds room for given roomName and capacity
	        protected static String addRoom(ArrayList<Room> roomList) {
		System.out.println("Add a room:");
		String name = getRoomName();
		int capacity = 0;     
                Room newRoom = null;
                do{
                    System.out.println("Room capacity? (1-10)");
                    while(!keyboard.hasNextInt()){
                    }
                capacity = keyboard.nextInt();
                }
                while(capacity ==0 || capacity >10);
                newRoom = new Room(name, capacity);
                roomList.add(newRoom);   
                                   
                return "Room '" + newRoom.getName() + "' added successfully!\nThankyou ";                  
}
        
        
//removeRoom romoves a room 
	/*gets roomname ,removes if added
	if no room added then it shows invalid room
	*/
	protected static String removeRoom(ArrayList<Room> roomList) {
		System.out.println("Remove a room:");
                String roomname1 = getRoomName();
                try{
		roomList.remove(findRoomIndex(roomList, roomname1));
                return ("Room '" +roomname1+ "'removed successfully! ");}
                catch(IndexOutOfBoundsException e){
                return ("Invalid Room");
                }             
	}
//Method listRoom lists the rooms ,if added else shows invalid room
	protected static String listRooms(ArrayList<Room> roomList) {
		System.out.println("Room Name - Capacity");
		System.out.println("---------------------");

		for (Room room : roomList) {
			System.out.println(room.getName() + " - " + room.getCapacity());
		}
		System.out.println("---------------------");
                return roomList.size() + " Room(s)";
	}
        
//Method scheduleRoom - schedules room for given day ,time and roomName
	protected static String scheduleRoom(ArrayList<Room> roomList) {
		System.out.println("Schedule a room:");
		String name = getRoomName();
                if(findRoomIndex(roomList,name) != -1){ 
                if(getRoomFromName(roomList, name) != null){
                Room curRoom = getRoomFromName(roomList, name);
		System.out.println("Start Date? (yyyy-mm-dd):");
		String startDate = keyboard.next();
		System.out.println("Start Time?");
		String startTime = keyboard.next();
		startTime = startTime + ":00.0";

		System.out.println("End Date? (yyyy-mm-dd):");
		String endDate = keyboard.next();
		System.out.println("End Time?");
		String endTime = keyboard.next();
		endTime = endTime + ":00.0";

		Timestamp startTimestamp = Timestamp.valueOf(startDate + " " + startTime);
		Timestamp endTimestamp = Timestamp.valueOf(endDate + " " + endTime);

		System.out.println("Subject?");
		String subject = keyboard.next();
		Meeting meeting = new Meeting(startTimestamp, endTimestamp, subject);
		curRoom.addMeeting(meeting);    
                return "Successfully scheduled!";
                }
                else{
                return "No such room added";
                }
                }
                else {
			return "No Room Added";
		}
                
	}
        
    /**
     *
     * @param roomList list
     * @param name roomName
     * @return value
     */
        protected static Room getRoomFromName(ArrayList<Room> roomList, String name) {
		try {
                    return roomList.get(findRoomIndex(roomList, name));
                }
                catch (IndexOutOfBoundsException e){
                   System.out.println("Invalid Room");
                return null;
                }
                
	}
//method findRoomIndex-gets the index to update roomList
	protected static int findRoomIndex(ArrayList<Room> roomList, String roomName) {
		int roomIndex = 0;
                if(roomList.isEmpty()){
                return -1;
                }
                else{
		for (Room room : roomList) {
			if (room.getName().compareTo(roomName) == 0) {
				break;
			}
			roomIndex++;
		}
        }

		return roomIndex;
        }
//method getRoomName - prompts user to enter room 
	protected static String getRoomName() {
		System.out.println("Room Name?");
		return keyboard.next();
	}
//Method exportRooms - exports data to JsonFile
//creating JosnFile 
    @SuppressWarnings("unchecked")
    private static String exportRooms(ArrayList<Room> rooms) {
        
		JSONArray roomObj = new JSONArray();

		for (Room room : rooms) {
			JSONObject Obj = new JSONObject();
			Obj.put("roomName", room.getName());
			Obj.put("capacity", room.getCapacity());
			roomObj.add(Obj);

		}

		FileWriter file;
		try {
			file = new FileWriter("room.json");
			file.write(roomObj.toJSONString());
			System.out.println("Successfully Copied ");
			System.out.println("\nJSON Object: " + roomObj);
			file.flush();
			file.close();
		} catch (IOException e1) {
			//  catch block
			e1.printStackTrace();
		}
                return  "";
    }
//Method exportSchedule - exports data to jsonFile by using fileWriter
    @SuppressWarnings("unchecked")
    private static String exportSchedule(ArrayList<Room> rooms) {
        JSONArray scheduleObj = new JSONArray();
		JSONObject singleRoomObj = new JSONObject();
		for (Room room : rooms) {
			System.out.println(room.getName());

			JSONArray meetingArrayObj = new JSONArray();
			for (Meeting m : room.getMeetings()) {
				JSONObject singleObj = new JSONObject();

				singleObj.put("starttime", m.getStartTime().toString());
				singleObj.put("stoptime", m.getStopTime().toString());
				System.out.println(singleObj);
				meetingArrayObj.add(singleObj);
			}

			singleRoomObj.put(room.getName(), meetingArrayObj);
			System.out.println(singleRoomObj);

		}

		scheduleObj.add(singleRoomObj);

		FileWriter file;
		try {
			file = new FileWriter("schedule.json");
			file.write(scheduleObj.toJSONString());
			System.out.println("Successfully Copied ");
			System.out.println("\nJSON Object: " + scheduleObj);
			file.flush();
			file.close();
		} catch (IOException e1) {
			// catch block
			e1.printStackTrace();
		}
                return "";
}
//method importRooms - import rooms from jsonFile created
    private static String importRooms(ArrayList<Room> rooms) {
        String data = fileReader("room.json");
		for (Object obj : getJSONArray(data)) {
			JSONObject obj1 = (JSONObject) obj;
			rooms.add(new Room(obj1.get("roomName").toString(), Integer.parseInt(obj1.get("capacity").toString())));
		}

		System.out.println("---------------------");
		System.out.println("Import Succesfull!!");
		System.out.println(listRooms(rooms));
                return "";
    }
//Method importSchedule - imports rooms from jsonFile which is created 
/*gets information from ,created schedule.json
*/
    private static String importSchedule(ArrayList<Room> rooms) {
        String data = fileReader("schedule.json");
        for (Object obj : getJSONArray(data)) {
	JSONObject obj2 = (JSONObject) obj;
	for (Room r : rooms) {
       for (Object newObj : getJSONArray(obj2.get(r.getName()).toString())) {
		JSONObject meetingObj = (JSONObject) newObj;
	        Timestamp newStartTime = Timestamp.valueOf(meetingObj.get("starttime").toString().split(" ")[0]
		                       + " " + meetingObj.get("starttime").toString().split(" ")[1]);
		Timestamp newEndTime = Timestamp.valueOf(meetingObj.get("stoptime").toString().split(" ")[0] + " "
		                        + meetingObj.get("stoptime").toString().split(" ")[1]);
	        Meeting m = new Meeting(newStartTime, newEndTime, "");
                r.getMeetings().add(m);
                                }			
			}
        
        System.out.println("---------------------");
        System.out.println("Import Succesfull");
        System.out.println(listSchedule(rooms));
		}  
                return "";
    
    }
    
//method fileReader - enables to read files
// TODO :MAKE final
    private static String fileReader(String file) {
      FileReader in = null;
		StringBuilder sb = new StringBuilder();

		try {
			in = new FileReader(file);
			char[] charBuffer = new char[1000];
			in.read(charBuffer);
			for (char c : charBuffer)
				sb.append(c);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return sb.toString().trim();
    }
//method getJSONArray - loop array
    private static Iterable<Object> getJSONArray(String data) {
       JSONArray array = null;
		JSONParser jparser = new JSONParser();
		try {
			Object ob = jparser.parse(data);
			array = (JSONArray) ob;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return array;
    }

}

