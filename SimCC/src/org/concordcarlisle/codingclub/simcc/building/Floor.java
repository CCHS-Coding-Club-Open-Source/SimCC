package org.concordcarlisle.codingclub.simcc.building;

import java.util.HashMap;
import java.util.Map;

import org.concordcarlisle.codingclub.simcc.SimCC;

public class Floor {
	private Map<Integer, Room> rooms = new HashMap<Integer, Room>(); //"Dictionary" of rooms. Stores as RoomNumber:RoomObject

	public Floor() {
		System.out.println("I'm a floor!");
		this.setRoom(23, new Room()); //TODO REMOVE THIS TEST CODE
	}
	
	/** Returns the room object for a room number on this floor.
	 *  This method will ignore the first digit if you give three.
	 * @param roomNumber The (preferably) two digit room number
	 * @return The Room Object
	 */
	public Room getRoom(int roomNumber) {
		/** Takes an integer and returns the room object for that room number.
		 * This method will ignore the first digit if you give three. **/
		if (roomNumber < 99) {
			return rooms.get(roomNumber);
		}else{
			int roomNum = (int) (roomNumber % (Math.floor(roomNumber / 100) * 100));
			return this.getRoom(roomNum);
		}
	}
	
	/** Takes an integer and a Room, and sets the room object for that room number.
	 *  This method will ignore the first digit if you give three.
	 * @param roomNumber The (preferably) two digit room number
	 * @param roomObject The 'new' Room Object to use/insert/store
	 */
	public void setRoom(int roomNumber, Room roomObject) {
		
		if (roomNumber < 100) {
			if(SimCC.DEBUG_MODE) System.out.println("Creating room number " + roomNumber);
			this.rooms.put(roomNumber, roomObject);
		}else{
			int roomNum = (int) (roomNumber % (Math.floor(roomNumber / 100) * 100));
			this.setRoom(roomNum, roomObject);
		}
	}
	
}
