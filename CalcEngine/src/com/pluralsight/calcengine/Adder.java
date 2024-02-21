package com.pluralsight.calcengine;

public class Adder extends CalculateBase implements MathProcessing {
    public Adder(){}
    public Adder(double x, double y){
        super(x,y);
    }
    @Override
    public void calculate(){
        double value = getX() + getY();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "add";
    }

    @Override
    public double doCalculation(double x, double y) {
        setX(x);
        setY(y);
        calculate();
        return getResult();
    }
}
