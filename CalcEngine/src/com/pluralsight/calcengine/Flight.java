package com.pluralsight.calcengine;

import java.util.ArrayList;
import java.util.Iterator;

public class Flight implements Comparable<Flight>, Iterable<Passenger>{
    private int passengers, seats=150, flightNumber;
    private static int allPassengers, maxPassengerPerFlight, totalCheckedBags;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];
    private ArrayList<Passenger> passengerList = new ArrayList<>();

    // This is an initializing block
    {
        for(int i =0; i<seats; i++){
            isSeatAvailable[i] = true;
        }
    }
    // When overwriting a base class method such as equals you need to write super.equals to use the base class definition
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Flight))
            return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && flightClass == flight.flightClass;
    }
    public int compareTo(Flight flight){return 1;} //Interface Contract to Comparable
    public Iterator<Passenger> iterator(){return passengerList.iterator();} //Interface Contract to Iterable

/*    static {
        AdminService admin = new AdminService();
        admin.connect();
        maxPassengerPerFlight = admin.isRestricted() ? admin.getMaxFlightPassengers() : Integer.MAX_VALUE;
        admin.close();
    }*/
    static void swapFlight(Flight i, Flight j){
        int k = i.getFlightNumber();
        i.setFlightNumber(j.getFlightNumber());
        j.setFlightNumber(k);
    }
    public Flight(int flightNumber){
        this();
        this.flightNumber=flightNumber;
    }
    public Flight(char flightClass){
        this();
        this.flightClass = flightClass;
    }
    public Flight(){}
    public void add1Passenger() {
        if (hasSeating()){
            passengers += 1;
            allPassengers += 1;
        }
        else
            handleTooMany();
    }
    public void add1Passenger(int bags){
        if(hasSeating()){
            add1Passenger();
            totalCheckedBags +=bags;
        }
    }
    public void add1Passenger(Passenger p){
        add1Passenger(p.getCheckedBags());
    }
    public void add1Passenger(int bags, int carryOns){
        if(carryOns <= 2)
            add1Passenger(bags);
    }
    public void add1Passenger(Passenger p, int carryOns){
        add1Passenger(p.getCheckedBags(),carryOns);
    }
    // variable length parameter list -> becomes array in method
    public void addPassengers(Passenger... list){
        if(hasSeating(list.length)){
            passengers+=list.length;
            for(Passenger passenger : list){
                totalCheckedBags += passenger.getCheckedBags();
            }
        }
    }
    private boolean hasSeating(){
        return passengers < seats;
    }
    private boolean hasSeating(int count){
        return passengers + count <= seats;
    }
    private void handleTooMany(){
        System.out.println("Too many!");
    }
    public static int getAllPassengers(){
        return allPassengers;
    }
    public static void resetAllPassengers(){
        allPassengers=0;
    }
    public boolean hasRoom(Flight flight){
        int total = this.passengers + flight.passengers;
        return total<=seats;
    }
    public Flight createNewWithBoth(Flight f2) {
        Flight newFlight = new Flight();
        newFlight.seats = seats;
        newFlight.passengers = passengers + f2.passengers;
        return newFlight;
    }
    public int getSeats(){
        return seats;
    }
    public void setSeats(int seats){
        this.seats = seats;
    }
    public int getPassengers(){
        return passengers;
    }
    public void setPassengers(){this.passengers = passengers;}
    public int getFlightNumber(){
        return this.flightNumber;
    }
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
}
