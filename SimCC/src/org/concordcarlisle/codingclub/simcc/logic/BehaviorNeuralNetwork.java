package org.concordcarlisle.codingclub.simcc.logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Movement behavior controlled by artificial neural networks.
 * @author Santiago Benoit
 */
public class BehaviorNeuralNetwork extends Behavior {
    
    public NeuralNetwork speedNeuralNetwork;
    public NeuralNetwork directionNeuralNetwork;
    
    public BehaviorNeuralNetwork() {
        speedNeuralNetwork = new NeuralNetwork();
        directionNeuralNetwork = new NeuralNetwork();
    }
    
    @Override
    public void setSpeed(Object... params) {
        ArrayList<Double> input = (ArrayList<Double>) params[0];
        double multiplier = (double) params[1];
        ArrayList<Double> output = speedNeuralNetwork.getOutput(input);
        double delta = multiplier * output.stream().mapToDouble(Double::doubleValue).sum();
        super.speed += delta;
    }

    @Override
    public void setDirection(Object... params) {
        ArrayList<Double> input = (ArrayList<Double>) params[0];
        ArrayList<Double> output = directionNeuralNetwork.getOutput(input);
        super.direction = output.indexOf(Collections.max(output));
    }
}
