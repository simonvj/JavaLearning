package com.pluralsight.calcengine;

// adding final before or after public makes it so you cannot inherit from the class
public class Passenger {
    private int checkedBags, freeBags;
    private double perBagFee;

    // default constructor if 1 constructor is defined all instances must be defined but by explicitly defining an empty one it'll be default
    public Passenger(){}
    public Passenger(int freeBags){
        this(freeBags > 1 ? 25.0d : 50.0d);
        this.freeBags = freeBags;
    }
    // chained to previous constructor
    public Passenger(int freeBags, int checkedBags){
        this(freeBags);
        this.checkedBags = checkedBags;
    }
    private Passenger(double perBagFee){
        this.perBagFee = perBagFee;
    }
    public int getCheckedBags(){
        return this.checkedBags;
    }
}
