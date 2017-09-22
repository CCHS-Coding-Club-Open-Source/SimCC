package org.concordcarlisle.codingclub.simcc;

import org.concordcarlisle.codingclub.simcc.building.Building;

public class SimCC {
	public static boolean DEBUG_MODE = true;
	// Declare
	static Building bldg;
	
	public static void main(String[] args) {
		// Initialize
		bldg = new Building();
		
		System.out.println("Hello, World!");
		
		//System.out.println(bldg.getFloor(1).getRoom(23));
	}

}
