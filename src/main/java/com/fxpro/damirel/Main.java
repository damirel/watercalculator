package com.fxpro.damirel;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        int[] array;
        try {
            Scanner scanner = new Scanner(System.in);
            LOGGER.info("Please enter the size of the landscape array:");
            int size = scanner.nextInt();
            array = new int[size];

            LOGGER.info(String.format("Please enter [%s] elements of landscape array:", size));
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();

        } catch (Exception e) {
            LOGGER.error(String.format("Landscape array contains illegal values!"));
            throw e;
        }

        LOGGER.info(String.format("Total water will be collected: [%s]",
                WaterCalculator.calculateWaterAmount(array)));
    }
}
