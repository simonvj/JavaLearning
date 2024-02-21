package com.pluralsight.calcengine;

// when a class has an abstract method the class itself must also be abstract

public abstract class Pilot {
    private Flight currentFlight;
    public void fly(Flight f){
        if(canAccept(f))
            currentFlight = f;
        else
            handleCantAccept();
    }
    public abstract boolean canAccept(Flight f);
    private void handleCantAccept(){System.out.println("Can't accept.");}
}
