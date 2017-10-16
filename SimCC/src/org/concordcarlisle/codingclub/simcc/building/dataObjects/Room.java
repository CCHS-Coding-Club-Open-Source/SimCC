package org.concordcarlisle.codingclub.simcc.building.dataObjects;


public class Room
{
	String floor; // Floor "Number" (which we treat as a string so that arrays can start at 1)
	int[] location = new int[3]; // (X, Y) of start
	int[] size = new int[2]; // (X length, Y length)
	int roomNumber;
	public Room() {
		System.out.println("I'm a room!");
	}
}
