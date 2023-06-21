package com.example.shop_store.test;

public class Calc {
    public int adding(int a, int b){
        return a + b;
    }

    public String gradeCalc(int grade){
        if(grade < 0){
            throw new IllegalArgumentException("it cant be");
        }else if(grade < 25){
            return "it is summer";
        }else if(grade < 50){
            return "it is retake";
        }else if(grade < 70){
            return "it is scholarship";
        }else if(grade < 90){
            return "it is upper scholarship";
        }else{
            return "you are smart";
        }
    }
}
