package com.example.shop_store.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void twoPlusTwoIsFour() {
        Calc calc = new Calc();
        assertEquals(4, calc.adding(2, 2));
    }
    @Test
    void fourPlusSixIsTen() {
        Calc calc = new Calc();
        assertEquals(10, calc.adding(4, 6));
    }

    @Test
    void twentyFourShouldReturnItIsSummer(){
        Calc calc = new Calc();
        assertEquals("it is summer", calc.gradeCalc(24));
    }
    @Test
    void fortyFourShouldReturnItIsRetake(){
        Calc calc = new Calc();
        assertEquals("it is retake", calc.gradeCalc(44));
    }
    @Test
    void sixtyFourShouldReturnItIsScholarship(){
        Calc calc = new Calc();
        assertEquals("it is scholarship", calc.gradeCalc(64));
    }
    @Test
    void eightyFourShouldReturnItIsUpperScholarship(){
        Calc calc = new Calc();
        assertEquals("it is upper scholarship", calc.gradeCalc(84));
    }
    @Test
    void ninetyFourShouldReturnItIsUpperScholarship(){
        Calc calc = new Calc();
        assertEquals("you are smart", calc.gradeCalc(94));
    }
    @Test
    void negativeOneShouldReturnIllegalArgumentException(){
        Calc calc = new Calc();
        assertThrows(IllegalArgumentException.class, () -> {
           calc.gradeCalc(-1);
        });
    }
}