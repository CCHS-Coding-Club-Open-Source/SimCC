package org.concordcarlisle.codingclub.simcc.building;

import java.util.HashMap;
import java.util.Map;

public class Building {
	private Map<Integer, Floor> floors = new HashMap<Integer, Floor>(); //"Dictionary" of floors. Stores as FloorNumber:FloorObject
	
	/** <b>A (or the) Building Object.</b><br>
	 *  <br>
	 *  Please Note:<br>
	 *  The Correct Convention for Room/Floor numbers will be:<br>
	 *  "Room 123" is actually "Room 23" of "Floor 1"<br>
	 *  "Room 234" is actually "Room 34" of "Floor 2"<br>
	 *  and so on.<br>
	 *  <br>
	 *  Please refrain from using three-digit room numbers,
	 *  	except for the final output (displayed value), where you should recombine the floor and room numbers.<br>
	 *  Although some parts of the code may handle them, it will create confusion and inconsistency.<br>
	 */
	public Building() {
		System.out.println("I'm a building!");
		setFloor(1, new Floor()); //TODO REMOVE THIS TEST CODE
	}
	
	public void setFloor(int floorNumber, Floor floorObject) {
		floors.put(floorNumber, floorObject);
	}
	
	public Floor getFloor(int floorNumber) {
		return floors.get(floorNumber);
	}
	
}