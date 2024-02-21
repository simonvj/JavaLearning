package com.pluralsight.organized;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("We are organized! \u00DA");
        float myFloat = 0.11f;
        double myDouble = 0.212341234;
        // Prefix and postfix (should not assign values inside print in reality)
        System.out.println(++myFloat);
        System.out.println(myFloat++);
        System.out.println(myFloat);
        // Compount assignment
        System.out.println(myFloat -= 1);
        System.out.println(myDouble /= myFloat * myFloat);
        System.out.println(myDouble);
        // Type conversion
        long myLong = 100;
        int myInt = (int) myLong; //explicit can also do implicit int myInt = myLong
        final int myFinalInt; // can be set here or later but never changed after set
        // Conditional assignment
        int value1 = 1;
        int value2 = 3;
        int maxValue = value1 > value2 ? value1 : value2;
        System.out.println(maxValue);
        // if-else
        int result = 0;
        String operation = "multipl";
        if(operation == "multiply")
            result = value1 * value2;
        else
            System.out.println("You can only multiply");
        System.out.println(result);
        int divisionNumber = 0;
        result = divisionNumber != 0 ? value1 / divisionNumber : 0; // will divide if not zero, otherwise return 0
        System.out.println(result);
        // for loop is like C
        for(int i =1; i<50; i*=2)
            System.out.println(i);
        // Array like python
        float[] myArray = new float[3];
        myArray[0] = 2.0f; myArray[1] = 1.0f; myArray[2]=50.0f;//etc..
        System.out.println(myArray[2]);
        float[] myArray2 = {1.0f, 2.0f, 3.2f}; // can also assign like this
        System.out.println(myArray2.length);
        // for each loop
        float sum = 0.0f;
        for(float currentVal : myArray2)
            sum += currentVal;
        System.out.println(sum);
        doSomething();
        int x = 1; int y = 5;
        switchValues(x,y);
        System.out.println(x); // method changes inside method does not carry over
        showSum(x,y,0);
        double resultDouble = returnSum(x,y);
        System.out.println(resultDouble);
        double[] arrayResults = new double[myArray2.length];
        char opCode = 'm';
        for(int i = 0; i < arrayResults.length; i++)
            arrayResults[i] = execute(opCode,myArray[i],myArray2[i]);
        System.out.println(arrayResults[2]);
        System.out.println(String.valueOf(value1));
        if(args.length ==1 && args[0].equals("interactive")){
            executeInteractively();
        }
        String location = "Alabama";
        int flightNumber = 275;
        StringBuilder sb = new StringBuilder(40);
        sb.append("Flight to "); sb.append(location); sb.append(" on Flight #"); sb.append(flightNumber);
        System.out.println(sb.toString());
        String time = "9:00";
        int position = sb.indexOf(" on");
        sb.insert(position, " at "); sb.insert(position+4, time);
        System.out.println(sb.toString());
        int w =5, i=235,j=400,k=12, big = 12391234;
        // string formatting using flags +(0#-,space
        System.out.printf("W:%4d X:%4d\n", w,i);
        System.out.printf("Y:%4d Z:%4d\n", j,k);

        System.out.printf("W:%04d X:%04d\n", w,i);
        System.out.printf("Y:%04d Z:%04d\n", j,k);

        System.out.printf("W:%-4d X:%-4d\n", w,i);
        System.out.printf("Y:%-4d Z:%-4d\n", j,k);

        System.out.printf("%,2d\n", big);

        System.out.printf("%+d\n%+d", -i,i);
        // order formatting $ is 1-based
        System.out.printf("%3$d %1$d %2$d\n", i,j,k);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter usDateFormat = DateTimeFormatter.ofPattern("MM-dd-yy");
        System.out.println(today.format(usDateFormat));

        String usDateString = "07-04-22";
        LocalDate theDate = LocalDate.parse(usDateString, usDateFormat);

        // primitive type to primitive wrapper class use capital letter long -> Long
        performCalculation();
    }

    static void checkRelationship(Instant otherInstant){
        Instant nowInstant = Instant.now();
        if(otherInstant.compareTo(nowInstant)>0)
            System.out.println("Instant is future");
        else if(otherInstant.compareTo(nowInstant)<0)
            System.out.println("Instant is past");
        else
            System.out.println("Instant is now");
    }

    private static void displayResult(char opCode, double x, double y, double result){
        char symbol = symbolFromOpCode(opCode);
        /*StringBuilder b = new StringBuilder(20);
        b.append(x); b.append(" "); b.append(symbol); b.append(" "); b.append(y); b.append(" = "); b.append(result);*/
        String output = String.format("%.2f %c %.2f = %.2f", x,opCode,y,result);
        System.out.println(output);
    }

    private static  char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's','m','d'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int i = 0; i<opCodes.length;i++){
            if(opCode==opCodes[i]){
                symbol=symbols[i];
                break;
            }
        }
        return symbol;
    }
    static void executeInteractively(){
        System.out.println("Enter an operation + 2 numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation((parts));
    }

    static void performCalculation(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100d, 50d, 'm');
        equations[1] = create(200d, 50d, 'd');
        equations[2] = create(300d, 50d, 'a');
        equations[3] = create(400d, 50d, 's');

        for(MathEquation equation : equations){
            equation.execute();
            System.out.println("results = " + equation.result);
        }


    }

    private static MathEquation create(double x, double y, char opCode) {
        MathEquation equation = new MathEquation();
        equation.x = x;
        equation.y = y;
        equation.opCode = opCode;
        return equation;
    }

    private static void performOperation(String[] parts){
        char opCode = opCodeFromString(parts[0]);
        if(opCode=='w')
            handleWhen(parts);
        else {
            double x = valueFromWord(parts[1]);
            double y = valueFromWord(parts[2]);
            double result = execute(opCode, x, y);
            displayResult(opCode, x, y, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        System.out.printf("%s plus %d days is %s\n", startDate, daysToAdd, newDate);
    }

    static char opCodeFromString(String operation){
        char opCode = operation.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word){
        String[] numberWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        double value = 0d;
        for(int i = 0; i < numberWords.length; i++){
            if(word.equals(numberWords[i])){
                value = i;
                break;
            }
        }
        if(value == 0d)
            value = Double.parseDouble(word);
        return value;
    }

    // method/function - void means returns nothing
    static void doSomething(){
        System.out.println("We're in the method");
    }
    static void switchValues(int val1, int val2){
        int k = val1;
        val1=val2;
        val2=k;
    }
    static void showSum(int x, int y, int count){
        if(count<1)
            return;
        float sum = x+y;
        for(int i =0; i<count; i++){
            System.out.println(sum);
        }
        return;
    }
    static double returnSum(double x, double y){
        return x+y;
    }
    /*static double[] returnSumArray(double x, double y){
        return x+y;
    }*/
    static double execute(char opCode, double x, double y){
        double result = 0;
        if(opCode=='m')
                result = x*y;
        else if(opCode=='a')
                result = x+y;
        else
            System.out.println("No such opCode!");
        return result;
    }

}

