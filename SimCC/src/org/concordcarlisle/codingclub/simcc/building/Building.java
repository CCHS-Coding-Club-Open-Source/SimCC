package org.concordcarlisle.codingclub.simcc.building;

import java.util.Map;

public class Building {
	private Map<Integer, Floor> floors; //"Dictionary" of floors. Stores as FloorNumber:FloorObject
	
	public Floor getFloor(int floorNumber) {
		return floors.get(floorNumber);
	}
	
}