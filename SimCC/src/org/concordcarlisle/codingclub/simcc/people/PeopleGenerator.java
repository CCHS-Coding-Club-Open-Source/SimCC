package org.concordcarlisle.codingclub.simcc.people;

import java.util.ArrayList;
import java.util.Random;

import org.concordcarlisle.codingclub.simcc.building.Building;

public class PeopleGenerator {

	public static Person generatePerson(Building buildingToBeIn) {
		
		Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((60 - 10) + 1) + 10;

		
		
		return new Person(buildingToBeIn, randomNum);
	}

	
	public static ArrayList<Person> generatePeople(int numberOfStudents, Building buildingToBeIn) {
		// TODO Improve this method. This will probably also mean changing generatePerson, and the person constructor and variables
		ArrayList<Person> people = new ArrayList<>();
		for(int i = 0; i < numberOfStudents; i++) {
			people.add(generatePerson(buildingToBeIn));
		}
		return people;
	}
}
