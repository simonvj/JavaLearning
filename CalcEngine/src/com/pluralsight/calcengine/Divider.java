package com.pluralsight.calcengine;

public class Divider extends CalculateBase{
    public Divider(){}
    public Divider(double x, double y) {
        super(x, y);
    }
    @Override
    public void calculate(){
        double value = getY() !=0 ? getX() / getY() : 0;
        setResult(value);
    }
}
