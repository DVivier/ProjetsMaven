package com.myapplication;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

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
    @Tag("Addition")
    @DisplayName("Addition de deux nombres positifs")
    void testAddTwoPositiveNumbers() {
//        fail("pas implémenté");
        int a = 1;
        int b = 2;

        int somme = calculator.add(a, b);

//        assertEquals(3,somme,"pas bon");
//        System.out.println(somme);
        assertThat(somme).isEqualTo(3);
    }

    //------------------
    @Test
    @Tag("Multiplication")
    @DisplayName("Multiplication par zéro")
    void testMultiplyByZero() {

        int a = 3;
        int b = 0;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(0,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isZero();
    }

    //------------------
    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    @Tag("Multiplication")
    @DisplayName("Multiplication par zéro (plusieurs cas)")
    public void testMultiplyShouldAlwaysReturnZero(int arg) {

        int resultatMultiplication = calculator.multiply(arg, 0);

//        assertEquals(0, resultatMultiplication);
        assertThat(resultatMultiplication).isZero();
    }

    //------------------
    @Test
    @DisplayName("Multiplication par 2)")
    void testMultiplyByTwo() {

        int a = 3;
        int b = 2;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(6,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isEqualTo(6);
    }


    //------------------
    @Test
    @DisplayName("Multiplication par 1)")
    void testMultiplyByOne() {

        int a = 3;
        int b = 1;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(3,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isEqualTo(3);
    }



    //------------------
    @Test
    @DisplayName("Multiplication par 3)")
    void testMultiplyByThree() {

        int a = 3;
        int b = 3;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(9,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isEqualTo(9);
    }

    //------------------
    @ParameterizedTest(name = "{0} * {1} doit être égale à {2}")
    @CsvSource({ "5,5,25", "7,8,56", "11,11,121" })
    @DisplayName("Plusieurs cas de multiplications par des nombres positifs)")
    void testMultiplyManyCasesWithTwoPositive(int a, int b,int resultatAttendu) {

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(resultatAttendu,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isEqualTo(resultatAttendu);
    }


    //------------------
    @Test
    @DisplayName("Multiplication par -1")
    void testMultiplyByNegativeOne() {

        int a = 3;
        int b = -1;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(-3,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).isEqualTo(-3);
    }


    //------------------
    @Test
    @DisplayName("Multiplication des 2 nombres négatifs")
    void testMultiplyByTwoNegatives() {

        int a = -4;
        int b = -3;
//        int attendu = 12;
        int attendu = 11;

        int resultatMultiplication = calculator.multiply(a, b);

//        assertEquals(12,resultatMultiplication,"pas bon");
        assertThat(resultatMultiplication).as("resultat de deux négatifs :").isEqualTo(12);
//        assertThat(resultatMultiplication).as("resultat de deux négatifs :").isEqualTo(11);
//        assertThat(resultatMultiplication).withFailMessage("doit être égal à %s, et pas à %s" , attendu, resultatMultiplication).isEqualTo(11);
    }

    @Test
    @DisplayName("Test pour tester @Disabled")
    @Disabled("Test non effectué car intule")
    void testInutile() {
        assertThat(1).as("test en dur :").isEqualTo(1);

    }

//    @Mock
}
