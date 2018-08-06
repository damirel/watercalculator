package com.fxpro.damirel;

import org.junit.Assert;
import org.junit.Test;

public class WaterCalculatorTest {

    @Test
    public void ExistWaterAmount() {
        Assert.assertEquals(9,
                WaterCalculator.calculateWaterAmount(new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}));

        Assert.assertEquals(6,
                WaterCalculator.calculateWaterAmount(new int[]{5, 2, 3, 4, 5}));
    }

    @Test
    public void EmptyWaterAmount() {
        Assert.assertEquals(0,
                WaterCalculator.calculateWaterAmount(new int[]{4, 3, 2, 1}));

        Assert.assertEquals(0,
                WaterCalculator.calculateWaterAmount(new int[]{2, 1}));

        Assert.assertEquals(0,
                WaterCalculator.calculateWaterAmount(new int[]{2, 2, 2}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidEmptyLandscape() {
        WaterCalculator.calculateWaterAmount(new int[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidValuesLandscape() {
        WaterCalculator.calculateWaterAmount(new int[]{-10, 2, 3, 4, 5, 4, 0, 3, -1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidBigLandscape() {
        int[] array = new int[32001];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        WaterCalculator.calculateWaterAmount(array);
    }
}