package com.pluralsight.calcengine;

public class DynamicHelper {
    private final MathProcessing[] handlers;
    public DynamicHelper(MathProcessing[] handlers){this.handlers = handlers;}
    public void process(String statement){
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0];
        double x = Double.parseDouble(parts[1]), y = Double.parseDouble(parts[2]);

        MathProcessing theHandler = null;
        for(MathProcessing handler: handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyWord())){
                theHandler = handler;
                break;
            }
        }
        double result = theHandler.doCalculation(x,y);
        System.out.println("result = " + result);
    }
}
