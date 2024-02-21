package com.pluralsight.calcengine;

public class Adder extends CalculateBase {
    public Adder(){}
    public Adder(double x, double y){
        super(x,y);
    }
    @Override
    public void calculate(){
        double value = getX() + getY();
        setResult(value);
    }
}
