package com.pluralsight.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // here follows a bunch of executions for example

        //performCalculations();
        Divider divider = new Divider();
        doCalculation(divider, 100d, 200d);
        Adder adder = new Adder();
        doCalculation(adder, 100d,200d);
        Flight f1 = new Flight(10);
        Flight f2 = new Flight(10);
        if(f1.equals(f2)){
            System.out.println("We did it!");
        }
        performMoreCalculations();

        // enum types/classes can be used in conditional logic
        FlightCrewJob job1 = FlightCrewJob.PILOT;
        FlightCrewJob job2 = FlightCrewJob.FLIGHT_ATTENDANT;
        if(job1 == FlightCrewJob.PILOT)
            System.out.println("Enum logic!");
        displayJobResponsibilities(job1);
        // enum can also be used relatively
        CrewMember grete = new CrewMember(FlightCrewJob.PILOT, "Grete");
        CrewMember hans = new CrewMember(FlightCrewJob.FLIGHT_ATTENDANT, "Hans");
        whoIsInCharge(grete, hans);

        // enum calc operation
        executeInteractively();
    }
    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }
    private static void performOperation(String[] parts){
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double x = Double.parseDouble(parts[1]), y = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation,x,y);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }
    private static CalculateBase createCalculation(MathOperation operation, double x, double y){
        CalculateBase calculation = null;
        switch (operation){
            case ADD:
                calculation = new Adder(x,y);
                break;
            case DIVIDE:
                calculation = new Divider(x,y);
                break;
            case MULTIPLY:
                calculation = new Multiplier(x,y);
                break;
            case SUBSTRACT:
                calculation = new Substractor(x,y);
                break;
        }
        return calculation;
    }
    static void whoIsInCharge(CrewMember m1, CrewMember m2){
        CrewMember theBoss = (m1.getJob().compareTo(m2.getJob()) > 0) ? m1 : m2;
        System.out.println(theBoss.getJob().getTitle() + " " + theBoss.getName() + " is boss.");
    }
    static void displayJobResponsibilities(FlightCrewJob job){
        switch (job){
            case FLIGHT_ATTENDANT:
                System.out.println("Assures passenger safety.");
                break;
            case PILOT:
                System.out.println("Flies the plane.");
                break;
            case CO_PILOT:
                System.out.println("Assists in flying the plane.");
                break;
        }
    }
    private static void performMoreCalculations(){
        CalculateBase[] calculations = {
                new Adder(10d, 50d),
                new Divider(40d, 3d),
                new Multiplier(32d, 24d),
                new Substractor(24d, 75d)
        };
        System.out.println();
        System.out.println("Array calculation");

        for(CalculateBase calculation : calculations){
            calculation.calculate();
            System.out.println("results = " + calculation.getResult());
        }
    }
    static void performCalculations(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a',25.0d, 92.0d);
        equations[2] = new MathEquation('s',225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }
        System.out.println("Average = " + MathEquation.getAverageResult());

        MathEquation equationOverload = new MathEquation('d');
        double x=2, y=5;
        equationOverload.execute(x,y);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        int xi = 3, yi = 4;
        equationOverload.execute(xi,yi);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

    }
    static void doCalculation(CalculateBase calculation, double x, double y){
        calculation.setX(x); calculation.setY(y);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

}



















