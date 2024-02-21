package com.pluralsight.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //performCalculations();
        Divider divider = new Divider();
        doCalculation(divider, 100d, 200d);
        Adder adder = new Adder();
        doCalculation(adder, 100d,200d);
        Flight f1 = new Flight(10);
        Flight f2 = new Flight(10);
        if(f1.equals(f2)){
            System.out.println("We did it!");
        }
        performMoreCalculations();
    }

    private static void performMoreCalculations(){
        CalculateBase[] calculations = {
                new Adder(10d, 50d),
                new Divider(40d, 3d),
                new Multiplier(32d, 24d),
                new Substractor(24d, 75d)
        };
        System.out.println();
        System.out.println("Array calculation");

        for(CalculateBase calculation : calculations){
            calculation.calculate();
            System.out.println("results = " + calculation.getResult());
        }
    }


    static void performCalculations(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a',25.0d, 92.0d);
        equations[2] = new MathEquation('s',225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }
        System.out.println("Average = " + MathEquation.getAverageResult());

        MathEquation equationOverload = new MathEquation('d');
        double x=2, y=5;
        equationOverload.execute(x,y);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        int xi = 3, yi = 4;
        equationOverload.execute(xi,yi);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

    }
    static void doCalculation(CalculateBase calculation, double x, double y){
        calculation.setX(x); calculation.setY(y);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

}



















