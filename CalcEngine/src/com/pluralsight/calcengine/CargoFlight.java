package com.pluralsight.calcengine;

public class CargoFlight extends Flight {
    float maxCargoSpace = 1000.0f, usedCargoSpace;
    int seats = 12;
    public CargoFlight(int flightNumber){
        super(flightNumber);
    }
    public CargoFlight(int flightNumber, float maxCargoSpace){
        this(flightNumber); // refers back to previously defined constructor
        this.maxCargoSpace = maxCargoSpace;
    }
    public CargoFlight(){}
    public CargoFlight(float maxCargoSpace){
        this.maxCargoSpace = maxCargoSpace;
    }
    public void add1Package(float h, float w, float d){
        float size = h * w * d;
        if(hasCargoSpace(size)){
            usedCargoSpace += size;
        }
        else{
            handleNoSpace();
        }
    }
    private boolean hasCargoSpace(float size){
        return usedCargoSpace + size <= maxCargoSpace;
    }
    private void handleNoSpace(){
        System.out.println("Not enough cargo space!");
    }
}
