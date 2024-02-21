package com.pluralsight.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyWord();
    double doCalculation(double x, double y);
    default String getFormattedOutput(){return null;} // making it default allows implementing new methods without breaking the classes that doesn't inherently include such a method


}
