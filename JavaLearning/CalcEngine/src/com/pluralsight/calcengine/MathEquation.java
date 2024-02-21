package com.pluralsight.calcengine;

public class MathEquation {
    // Note: Getters and Setters have been added for leftVal, rightVal, and opCode
    private double x, y, result;
    private char opCode;
    private static int numberOfCalculations;
    private static double sumOfResults;

    // Note: Only a Getter has been added for result. The result field should *not* be directly
    //       changed from outside the class. The result field should only be set as a result
    //       of calling the execute method.
    public MathEquation(){}
    public MathEquation(char opCode) {
        this.opCode = opCode;
    }
    public MathEquation(char opCode, double x, double y){
        this(opCode);
        this.x = x;
        this.y = y;
    }

    public void execute() {
        switch (opCode) {
            case 'a':
                result = x + y;
                break;
            case 's':
                result = x - y;
                break;
            case 'm':
                result = x * y;
                break;
            case 'd':
                result = y != 0 ? x / y : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        numberOfCalculations++;
        sumOfResults += result;

    }

    public void execute(double x, double y){
        this.x = x;
        this.y = y;
        execute();
    }

    public void execute(int x, int y){
        this.x = x;
        this.y = y;
        execute();
        result = (int)result;
    }

    public static double getAverageResult(){
        return sumOfResults/numberOfCalculations;
    }
    public double getLeftVal() {
        return x;
    }

    public void setLeftVal(double x) {
        this.x = x;
    }

    public double getRightVal() {
        return y;
    }

    public void setRightVal(double y) {
        this.y = y;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }



}
