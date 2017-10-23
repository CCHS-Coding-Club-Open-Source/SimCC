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
    
    public static void main(String[] args) { // Example of evolution algorithm. Remove from final product.
        ArrayList<NeuralNetwork> networks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            NeuralNetwork network = new NeuralNetwork();
            network.addLayer(1, "");
            network.addLayer(10, "relu");
            network.addLayer(1, "relu");
            network.randomizeWeights();
            network.randomizeBiases(-1, 1);
            networks.add(network);
        }
        int count = 0;
        while (true) {
            ArrayList<Double> input = new ArrayList<>();
            input.add(1d);
            ArrayList<Double> outputs = new ArrayList<>();
            for (NeuralNetwork network : networks) {
                double output = network.getOutput(input).stream().mapToDouble(Double::doubleValue).sum();
                outputs.add(output);
            }
            double max = Collections.max(outputs);
            NeuralNetwork winner = networks.get(outputs.indexOf(max));
            System.out.println("Epoch " + count + ": " + max);
            networks.clear();
            networks.add(winner);
            for (int i = 0; i < 99; i++) {
                NeuralNetwork clone = winner.deepCopy();
                clone.mutate(0.25, 0.25);
                networks.add(clone);
            }
            count++;
        }
    }
}
