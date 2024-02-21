package com.pluralsight.calcengine;

public class Substractor extends CalculateBase {
    public Substractor(){}
    public Substractor(double x, double y) {
        super(x, y);
    }
    @Override
    public void calculate(){
        double value = getX() - getY();
        setResult(value);
    }
}
