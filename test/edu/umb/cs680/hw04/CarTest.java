package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {
    private String[] carToStringArray(Car c) {
        String[] array = { c.getMaker(), c.getModel(), c.getYear().toString() };
        return array;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = { "Tesla", "CyberTruck", "2022" };
        Car actual = new Car("Tesla", "CyberTruck", 2022, 300, 75000.00f);

        Car car1 = new Car("BMW", "x6", 2023, 380, 65000.00f);
        Car car2 = new Car("BMW", "x6", 2023, 380, 65000.00f);

        assertArrayEquals(expected, carToStringArray(actual));
        assertArrayEquals(carToStringArray(car1), carToStringArray(car2));
    }
};
