package org.concordcarlisle.codingclub.simcc.building;

import java.util.Map;

public class Floor {
	Map<Integer, Room> rooms; //"Dictionary" of rooms. Stores as RoomNumber:RoomObject

	public Room getRoom(int roomNumber) {
		if (roomNumber < 99) {
			return rooms.get(roomNumber);
		}else{
			int roomNum = roomNumber % (Math.floor(roomNumber / 100) * 100);
			return rooms.get(roomNum);
		}
	}
	
	
}
