package org.concordcarlisle.codingclub.simcc.building.physicalObjects;

public class PhysicalObject {
	// The position on the floor. Note this will only work for rectangular shapes. Stores the coordinates of two opposite corners given as [[X1, Y1], [X2, Y2]]
	private int[][] positionOnFloor = new int[2][2];
	
	// If isDoor && !isLocked, then isSolid can be toggled.
	private boolean isSolid;  // If isSold, solid for path-finding.
	private boolean isDoor;  // Indicates the object is a door.
	private boolean isLocked;  // If isDoor, can be toggled by a teacher.
	
	
	public PhysicalObject(int[][] desiredPositionOnFloor) {
		setPositionOnFloor(desiredPositionOnFloor);
	}
	
	public PhysicalObject(int[][] desiredPositionOnFloor, boolean isDoor) {
		this(desiredPositionOnFloor);
		this.isDoor = isDoor;
	}

	
	
	
	/*
	 * --------------------------
	 * Interaction methods below
	 * --------------------------
	 */
	
	/**
	 * If the object is a door, and it's not locked, then toggle the door.
	 * @return Whether the door was toggled. Might not always be useful to know, but it's here if needed.
	 */
	public boolean toggleOpen() {
		if( isDoor && ( (isSolid && !isLocked) || (!isSolid) ) ) {  // If it's a door, and EITHER (Closed & unlocked) OR (Open), then toggle the door.
			isSolid = !isSolid;
			return true; // Door was toggled
		} else {
			return false; // Door was not toggled
		}
	}
	
	
	
	/*
	 * --------------------------
	 * Getters and Setters below
	 * --------------------------
	 */
	
	
	// Getters for solid/door/locked variables (since they're private)
	public boolean isSolid() { return isSolid; }
	public boolean isDoor() { return isDoor; }
	public boolean isLocked() {	return isLocked; }

	public int[][] getPositionOnFloor() {
		return positionOnFloor;
	}

	private void setPositionOnFloor(int[][] positionOnFloor) {
		this.positionOnFloor = positionOnFloor;
	}
	
	

}
