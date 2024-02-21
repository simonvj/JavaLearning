package com.pluralsight.organized;

public class MathEquation {
    double x, y, result;
    char opCode;

    double execute(){
        result = 0;
        if(opCode=='m')
            result = x*y;
        else if(opCode=='a')
            result = x+y;
        else
            System.out.println("No such opCode!");
        return result;
    }
}
