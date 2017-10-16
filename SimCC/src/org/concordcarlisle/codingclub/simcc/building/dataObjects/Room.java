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
	public [][] studentRooms(rooms[], students[]) {//change to map??
		for (Int a : rooms[]) {
			//SiR = Students in Room
			//SPR = StudentsPerRoom
			for (SiR = 0; SiR < SPR; SiR++){
				studentRooms[room[i]][students[SiR]];
				
			}
		}
		}
	}
}
