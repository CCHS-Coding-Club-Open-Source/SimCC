package org.concordcarlisle.codingclub.simcc;


public class Student extends Person
{
   double gpa;
   int yog, motivationLevel;
   boolean attendingClass;
   
   public Student(double g, int y, int m)
   {
      gpa = g;
      yog = y;
      motivationLevel = m;
   }
   
   public void skipClass()
   {
      attendingClass = false;
   }
}
