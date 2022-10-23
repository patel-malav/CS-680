package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void generatePrimesBetween_1_to_150() {

        PrimeGenerator cut = new PrimeGenerator(1, 150);
        cut.generatePrimes();

        Long[] result = (Long[]) cut.getPrimes().toArray(new Long[0]);

        Long[] actualPrimesBetween1to150 = { 2l, 3l, 5l, 7l, 11l, 13l,
                17l, 19l, 23l, 29l, 31l, 37l, 41l, 43l, 47l, 53l, 59l,
                61l, 67l, 71l, 73l, 79l, 83l, 89l, 97l, 101l, 103l,
                107l, 109l, 113l, 127l, 131l, 137l, 139l, 149l };

        assertArrayEquals(result, actualPrimesBetween1to150);
    }

    @Test
    public void generatePrimesBetween_Minus10_to_10() {

        Long from = -10l;
        Long to = 10l;
        try {
            new PrimeGenerator(from, to);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + from + " to=" + to);
        }
    }

    @Test
    public void generatePrimesBetween_1_to_Minus10() {
        Long from = 1l;
        Long to = -10l;
        try {
            new PrimeGenerator(from, to);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + from + " to=" + to);
        }
    }

    @Test
    public void generatePrimesBetween_20_to_1() {
        Long from = 20l;
        Long to = 1l;
        try {
            new PrimeGenerator(from, to);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + from + " to=" + to);
        }
    }

    @Test
    public void generatePrimesBetween_1_to_1() {
        Long from = 1l;
        Long to = 1l;
        try {
            new PrimeGenerator(from, to);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + from + " to=" + to);
        }
    }

    @Test
    public void generatePrimesBetween_12_to_12() {
        Long from = 12l;
        Long to = 12l;
        try {
            new PrimeGenerator(from, to);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Wrong input values: from=" + from + " to=" + to);
        }
    }

    @Test
    public void checkIfArrayIsEmptyWhen_genPrimes_MethodIsNotCalled() {
        PrimeGenerator cut = new PrimeGenerator(1, 150);

        Long[] result = (Long[]) cut.getPrimes().toArray(new Long[0]);

        Long[] actual = {};

        assertArrayEquals(result, actual);
    }
}
