package com.fxpro.damirel;

import org.apache.log4j.Logger;

public class WaterCalculator {

    private static final Logger LOGGER = Logger.getLogger(WaterCalculator.class);

    /**
     * Calculates total amount of water that current landscape can collect and returns long value
     *
     * @param landscape array
     * @return long total water collected
     */
    public static long calculateWaterAmount(int[] landscape) {

        if (!isLandscapeValid(landscape)) {
            String error = "Wrong input array!";
            LOGGER.debug(error);
            throw new IllegalArgumentException(error);
        }

        long waterAmount = 0;
        int size = landscape.length;
        int[] maxRightHeightPreCalculate = new int[size];

        // Fill extra array with max height on right side
        maxRightHeightPreCalculate[size - 1] = landscape[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRightHeightPreCalculate[i] =
                    Math.max(maxRightHeightPreCalculate[i + 1], landscape[i]);
        }

        // Calculate amount of water for each pit
        int maxHeightFromLeft = 0;
        for (int i = 0; i < size; i++) {
            if (maxHeightFromLeft < landscape[i]) {
                maxHeightFromLeft = landscape[i];
            }
            int minLeftRightHills = Math.min(maxHeightFromLeft, maxRightHeightPreCalculate[i]);
            waterAmount += (minLeftRightHills - landscape[i]);
        }
        return waterAmount;
    }

    /**
     * Check if specified array is valid for calculating. It shouldn't has more then 32000 values
     * Height should be between 0 and 32000
     *
     * @param landscape array
     * @return boolean
     */
    public static boolean isLandscapeValid(int[] landscape) {
        if (landscape.length > 32000 || landscape.length == 0) {
            return false;
        }
        for (int i = 0; i < landscape.length; i++) {
            if (landscape[i] < 0 || landscape[i] > 32000) {
                return false;
            }
        }
        return true;
    }
}