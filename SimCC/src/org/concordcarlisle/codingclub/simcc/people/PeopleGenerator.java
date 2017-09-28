package org.concordcarlisle.codingclub.simcc.people;

import org.concordcarlisle.codingclub.simcc.building.Building;

public class PeopleGenerator {

	public static Person generatePerson(Building buildingToBeIn) {
		return new Person(buildingToBeIn);
	}

}
