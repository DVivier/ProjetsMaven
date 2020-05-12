package com.myapplication;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private static Calculator calculator;
    private static Instant startedAt;

    @BeforeAll
    static void avantTousLesTests() {
        calculator = new Calculator();
        startedAt = Instant.now();
    }

    @AfterAll
    static void apresTousLestests() {
        Instant enedAt = Instant.now();
        long duration = Duration.between(startedAt,enedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests {0} ms",duration));
    }

    //------------------
    @Test
    void testAddTwoPositiveNumbers() {
//        fail("pas implémenté");
        int a = 1;
        int b = 2;

        int somme = calculator.add(a, b);

        assertEquals(3,somme,"pas bon");
    }

    //------------------
    @Test
    void testMultiplyByZero() {

        int a = 3;
        int b = 0;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(0,resultatMultiplication,"pas bon");
    }

    //------------------
    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    public void testMultiplyShouldAlwaysReturnZero(int arg) {

        int resultatMultiplication = calculator.multiply(arg, 0);

        assertEquals(0, resultatMultiplication);
    }

    //------------------
    @Test
    void testMultiplyByTwo() {

        int a = 3;
        int b = 2;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(6,resultatMultiplication,"pas bon");
    }


    //------------------
    @Test
    void testMultiplyByOne() {

        int a = 3;
        int b = 1;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(3,resultatMultiplication,"pas bon");
    }


    //------------------
    @Test
    void testMultiplyByThree() {

        int a = 3;
        int b = 3;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(9,resultatMultiplication,"pas bon");
    }

    //------------------
    @ParameterizedTest(name = "{0} * {1} doit être égale à {2}")
    @CsvSource({ "5,5,25", "7,8,56", "11,11,121" })
    void testMultiplyManyCasesWithTwoPositive(int a, int b,int resultatAttendu) {

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(resultatAttendu,resultatMultiplication,"pas bon");
    }


    //------------------
    @Test
    void testMultiplyByNegativeOne() {

        int a = 3;
        int b = -1;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(-3,resultatMultiplication,"pas bon");
    }


    //------------------
    @Test
    void testMultiplyByTwoNegatives() {

        int a = -4;
        int b = -3;

        int resultatMultiplication = calculator.multiply(a, b);

        assertEquals(12,resultatMultiplication,"pas bon");
    }

}
