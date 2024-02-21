package com.pluralsight.calcengine;

// adding final before or after public makes it so you cannot inherit from the class
public class Passenger implements Comparable<Passenger> {
    private int checkedBags, freeBags;
    private double perBagFee;
    private String name;
    public static class RewardProgram{
        private  int memberDays, memberLevel; // member level 3 (1st priority),2,1
        public int getMemberLevel(){return memberLevel;}
        public void setMemberLevel(int level){this.memberLevel = level;}
        public int getMemberDays() {
            return memberDays;
        }
        public void setMemberDays(int memberDays) {
            this.memberDays = memberDays;
        }
    }

    private RewardProgram rewardProgram = new RewardProgram();

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
    public Passenger(String name, int memberLevel, int memberDays){
        this.name = name;
        rewardProgram.memberLevel = memberLevel;
        rewardProgram.memberDays = memberDays;
    }
    public int compareTo(Passenger p){
        int returnValue = p.rewardProgram.memberLevel - p.rewardProgram.memberLevel;
        if(returnValue ==0)
            returnValue = p.rewardProgram.memberDays - p.rewardProgram.memberDays;
        return returnValue;
    }
    public int getCheckedBags(){
        return this.checkedBags;
    }
    public String getName(){return name;}
}
