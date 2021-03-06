package org.concordcarlisle.codingclub.simcc.people;

import java.util.Random;

import org.concordcarlisle.codingclub.simcc.building.Building;
import org.concordcarlisle.codingclub.simcc.logic.Behavior;

/**
 * Person class initiated by ABeckwith
 */
public class Person
{
	Building building;
	String nameOfPerson;
	int[] location = new int[3];
	int age, speed, stressLevel, amountOfSleep;
	boolean license, car;
	Schedule schedule;
	int[] size = new int[] {10, 10}; // arbitrary circle size
        Behavior behavior;

	public Person(Building buildingToBeIn, String name, int loc[], int age)
	{
		this.building = buildingToBeIn;
		nameOfPerson  = name;
		location      = loc;
		this.age      = age;
	}

	public Person(String name, int[] loc, int age, int sp, int stress, int sleep, boolean l, boolean c, Schedule s)
	{
		nameOfPerson  = name;
		location      = loc;
		this.age      = age;
		speed         = sp;
		stressLevel   = stress;
		amountOfSleep = sleep;
		license       = l;
		car           = c;
		schedule      = s;
	}

	public Person(Building buildingToBeIn, int age) {
		this.building = buildingToBeIn;
		
		
		this.age = age;
	}

	public void goToStair()
	{}

	public void leaveBuilding()
	{
		goToStair();
	}

	public void tick() {
		System.out.println("Person tick. Age " + age);
		// TODO Auto-generated method stub
		
	}
}
