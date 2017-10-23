package org.concordcarlisle.codingclub.simcc.logic;

import java.util.ArrayList;
import java.util.Collections;
import org.concordcarlisle.codingclub.simcc.util.Util;

/**
 * Artificial neural network.
 * @author Santiago Benoit
 */
public class NeuralNetwork {
    
    private ArrayList<Integer> layers;
    private ArrayList<String> activations;
    private ArrayList<ArrayList<Double>> weights;
    private ArrayList<Double> biases;
    
    public NeuralNetwork() {
        layers = new ArrayList<>();
        activations = new ArrayList<>();
        weights = new ArrayList<>();
        biases = new ArrayList<>();
    }
    
    public NeuralNetwork deepCopy() {
        NeuralNetwork clone = new NeuralNetwork();
        clone.setLayers((ArrayList<Integer>) layers.clone(), (ArrayList<String>) activations.clone());
        ArrayList<ArrayList<Double>> newWeights = new ArrayList<>();
        weights.stream().forEach((weightLayer) -> {
            newWeights.add((ArrayList<Double>) weightLayer.clone());
        });
        clone.setWeights(newWeights);
        clone.setBiases((ArrayList<Double>) biases.clone());
        return clone;
    }
    
    public void setLayers(ArrayList<Integer> layers, ArrayList<String> activations) {
        this.layers = layers;
        this.activations = activations;
    }
    
    public void addLayer(int layerSize, String activation) {
        if (!layers.isEmpty()) {
            int numWeights = layerSize * layers.get(layers.size() - 1);
            weights.add(new ArrayList<>(Collections.nCopies(numWeights, 0d)));
            biases.add(0d);
        }
        layers.add(layerSize);
        activations.add(activation);
    }
    
    public void setWeights(ArrayList<ArrayList<Double>> weights) {
        this.weights = weights;
    }
    
    public void randomizeWeights() {
        for (int i = 0; i < weights.size(); i++) {
            int inputs = layers.get(i);
            for (int j = 0; j < weights.get(i).size(); j++) {
                weights.get(i).set(j, Util.randDouble(-1 / Math.sqrt(inputs), 1 / Math.sqrt(inputs)));
            }
            //weights.set(i, weights.get(i).stream()
            //        .map(weight -> Util.randDouble(-1 / Math.sqrt(inputs), 1 / Math.sqrt(inputs))));
        }
        //weights.stream()
        //        .map(layer -> layer.stream()
        //                .map(weight -> Util.randDouble(-1 / Math.sqrt(layers.get(weights.indexOf(layer))), 1 / Math.sqrt(layers.get(weights.indexOf(layer)))))
        //        );
    }
    
    public void setBiases(ArrayList<Double> biases) {
        this.biases = biases;
    }
    
    public void randomizeBiases(double min, double max) {
        for (int i = 0; i < biases.size(); i++) {
            biases.set(i, Util.randDouble(min, max));
        }
//        biases.stream()
//                .map(bias -> Util.randDouble(min, max));
    }
    
    public void mutate(double mutationRate, double maxChange) {
        for (int i = 0; i < weights.size(); i++) {
            for (int j = 0; j < weights.get(i).size(); j++) {
                if (Util.randDouble(0, 1) <= mutationRate) {
                    weights.get(i).set(j, weights.get(i).get(j) + Util.randDouble(-maxChange, maxChange));
                }
            }
        }
        for (int i = 0; i < biases.size(); i++) {
            if (Util.randDouble(0, 1) <= mutationRate) {
                biases.set(i, biases.get(i) + Util.randDouble(-maxChange, maxChange));
            }
        }
    }
    
    public ArrayList<Integer> getLayers() {
        return layers;
    }
    
    public ArrayList<String> getActivations() {
        return activations;
    }

    public ArrayList<ArrayList<Double>> getWeights() {
        return weights;
    }
    
    public ArrayList<Double> getBiases() {
        return biases;
    }
    
    public ArrayList<Double> getOutput(ArrayList<Double> input) {
        return getOutput(input, layers.size() - 1);
    }
    
    public ArrayList<Double> getOutput(ArrayList<Double> input, int layer) {
        if (layer == 0) {
            return applyActivation(input, activations.get(layer));
        } else {
            ArrayList<Double> current = getOutput(input, layer - 1);
            ArrayList<Double> output = new ArrayList<>();
            int index = 0;
            for (int j = 0; j < layers.get(layer); j++) {
                double newValue = biases.get(layer - 1);
                for (double value : current) {
                    newValue += value * weights.get(layer - 1).get(index);
                    index++;
                }
                output.add(newValue);
            }
            return applyActivation(output, activations.get(layer));
        }
    }
    
    public ArrayList<Double> applyActivation(ArrayList<Double> input, String activation) {
        switch (activation) {
            case "sigmoid":
                return sigmoid(input);
            case "relu":
                return relu(input);
            case "softmax":
                return softmax(input);
            default:
                return input;
        }
    }
    
    public static ArrayList<Double> sigmoid(ArrayList<Double> input) {
        ArrayList<Double> output = new ArrayList<>();
        input.stream().forEach((value) -> {
            output.add(1 / (1 + Math.exp(-value)));
        });
        return output;
    }
    
    public static ArrayList<Double> relu(ArrayList<Double> input) {
        ArrayList<Double> output = new ArrayList<>();
        input.stream().forEach((value) -> {
            output.add(Math.max(0, value));
        });
        return output;
    }
    
    public static ArrayList<Double> softmax(ArrayList<Double> input) {
        ArrayList<Double> output = new ArrayList<>();
        double totalValue = 0;
        totalValue = input.stream()
                .map((value) -> value)
                .reduce(totalValue, (accumulator, _item) -> accumulator + Math.exp(_item));
        for (double value : input) {
            output.add(Math.exp(value) / totalValue);
        }
        return output;
    }
    
//    public static void main(String[] args) {
//        NeuralNetwork nn = new NeuralNetwork();
//        nn.addLayer(16, "");
//        nn.addLayer(8, "relu");
//        nn.addLayer(4, "softmax");
//        nn.randomizeWeights();
//        nn.randomizeBiases(-1d, 1d);
//        System.out.println(nn.layers);
//        System.out.println(nn.weights);
//        System.out.println(nn.biases);
//        nn.mutate(0.5, 0.1);
//        System.out.println(nn.weights);
//        System.out.println(nn.biases);
//        System.out.println(nn.activations);
//        Double[] test = {-4d, 4d, -2d, -6d, -1d, -5.3d, -1d, -4d};
//        System.out.println(nn.getOutput(new ArrayList(Arrays.asList(test))));
//    }
}
