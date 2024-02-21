package com.pluralsight.calcengine;
//
public abstract class CalculateBase {
    private double x,y,result;

    public CalculateBase(){}
    public CalculateBase(double x, double y){
        this.setX(x);
        this.setY(y);
    }
    public double getX(){return x;}
    public void setX(double x){this.x = x;}
    public double getY(){return y;}
    public void setY(double y){this.y = y;}
    public double getResult(){return result;}
    public void setResult(double result){this.result = result;}
    // when abstract we expect it to be overwritten
    public abstract void calculate();
}
