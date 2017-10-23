package org.concordcarlisle.codingclub.simcc.util;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Contains utility methods.
 * @author Santiago Benoit
 */
public class Util {
    
    public static int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);  // [inclusive, exclusive)
    }
    
    public static double randDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);  // [inclusive, exclusive)
    }
}
