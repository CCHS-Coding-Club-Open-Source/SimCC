package org.concordcarlisle.codingclub.simcc;


/**
 * Person class initiated by ABeckwith
 */
public class Person
{
	String nameOfPerson;
	int[] location = new int[3];
	int age, speed, stressLevel, amountOfSleep;
	boolean license, car;
	Schedule schedule;
	int[] size = new int[] {10, 10}; // arbitrary circle size

	public Person(String name, int loc[], int age)
	{
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

	public void goToStair()
	{}

	public void leaveBuilding()
	{
		goToStair();
	}
}
