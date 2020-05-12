package com.myapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAddTwoPositiveNumbers() {
//        fail("pas implémenté");
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 2;

        int somme = calculator.add(a, b);

        assertEquals(3,somme,"pas bon");
    }

    @Test
    void testMultiplyByZero() {

        Calculator calculator = new Calculator();
        int a = 3;
        int b = 0;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(0,resultatMultiplication,"pas bon");
    }

    @Test
    void testMultiplyByTwo() {

        Calculator calculator = new Calculator();
        int a = 3;
        int b = 2;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(6,resultatMultiplication,"pas bon");
    }

    @Test
    void testMultiplyByOne() {

        Calculator calculator = new Calculator();
        int a = 3;
        int b = 1;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(3,resultatMultiplication,"pas bon");
    }

    @Test
    void testMultiplyByThree() {

        Calculator calculator = new Calculator();
        int a = 3;
        int b = 3;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(9,resultatMultiplication,"pas bon");
    }

    @Test
    void testMultiplyByNegativeOne() {

        Calculator calculator = new Calculator();
        int a = 3;
        int b = -1;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(-3,resultatMultiplication,"pas bon");
    }

    @Test
    void testMultiplyByTwoNegatives() {

        Calculator calculator = new Calculator();
        int a = -4;
        int b = -3;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(12,resultatMultiplication,"pas bon");
    }

}
