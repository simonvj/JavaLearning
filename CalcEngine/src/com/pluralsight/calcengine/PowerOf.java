package com.pluralsight.calcengine;

public class PowerOf implements MathProcessing{
    private String formattedOutput;
    @Override
    public String getKeyWord() {
        return "power";
    }

    @Override
    public String getFormattedOutput() {
        return MathProcessing.super.getFormattedOutput();
    }

    @Override
    public double doCalculation(double x, double y) {
        double product = Math.pow(x,y);
        formattedOutput = x + " to the power of " + y + " is " + product;
        return product;
    }
}
