package org.concordcarlisle.codingclub.simcc.logic;

/**
 * Abstract class to be extended into specific behaviors for map navigation (such as different pathfinding algorithms).
 * @author Santiago Benoit
 */
public abstract class Behavior {
    
    protected double speed;
    protected double direction;
    
    public Behavior() {
        
    }
    
    public abstract void setSpeed(Object... params);
    
    public abstract void setDirection(Object... params);
    
    public double getSpeed() {
        return speed;
    }
    
    public double getDirection() {
        return direction;
    }
}
