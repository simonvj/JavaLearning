package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase{
    public Multiplier(){}
    public Multiplier(double x, double y){
        super(x, y);
    }
    @Override
    public void calculate(){
        double value = getX() * getY();
        setResult(value);
    }
}
