package org.concordcarlisle.codingclub.simcc;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.concordcarlisle.codingclub.simcc.building.Building;
import org.concordcarlisle.codingclub.simcc.people.PeopleGenerator;
import org.concordcarlisle.codingclub.simcc.people.Person;

public class SimCC {
	public static boolean DEBUG_MODE = true;
	public static int BUILDING_POPULATION = 100;
	// Declare
	static Building bldg;
	static ArrayList<Person> people = new ArrayList<Person>();
	
	public static void main(String[] args) {
		// Initialize
		bldg = new Building();
		
		System.out.println("Hello, World!");
		
		//System.out.println(bldg.getFloor(1).getRoom(23));
		
		populatePeople(BUILDING_POPULATION);
		logicTick();//logicLoop(); Run once for now. TODO Get logic so that stuff is changing, and use the loop.
	}
	
	private static void populatePeople(int numberOfStudents) {
		for(int i = 0; i < numberOfStudents; i++) {
			people.add(PeopleGenerator.generatePerson(bldg));
		}
	}
	
	@SuppressWarnings("unused") //TODO this should be temporary while we aren't using the loop
	private static void logicLoop() {
		Timer timer = new Timer();
		TimerTask tickTask = new TimerTask() {
		    @Override
		    public void run() {
		        logicTick();
		    }
		};

		timer.schedule(tickTask, 0, 2000);
	}
	
	private static void logicTick() {
		System.out.println("logicTick called");
		
		for(Person p : people) {
			p.tick();
		}
		
	}
}
