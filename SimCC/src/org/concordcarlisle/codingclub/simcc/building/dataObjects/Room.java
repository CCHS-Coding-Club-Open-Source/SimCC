package org.concordcarlisle.codingclub.simcc.building.dataObjects;

import org.concordcarlisle.codingclub.simcc.people.Student;

public class Room
{
	String floor; // Floor "Number" (which we treat as a string so that arrays can start at 1)
	int[] location = new int[3]; // (X, Y) of start
	int[] size = new int[2]; // (X length, Y length)
	int roomNumber;
	public Room() {
		System.out.println("I'm a room!");
	}
	
	//TODO Fix whatever this is supposed to be doing
	/*public [][] studentRooms(Room[] rooms, Student[] students) {//change to map??
		for (Room r : rooms) {
			//SiR = Students in Room
			//SPR = StudentsPerRoom
			
			for (SiR = 0; SiR < SPR; SiR++){
				studentRooms[room[i]][students[SiR]];
				
			}
			
		}
	}*/
}
