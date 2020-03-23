package Main;

import Interface.IOperation;
import Parsers.Arab;
import Parsers.Roman;

import java.util.Scanner;

public class Calculator {
    private Roman r = new Roman();
    private IOperation io;
    private int first, second;
    private char operand;
    private String[] numbers;
    private static String input;
    private static Scanner line = new Scanner(System.in);

    private void setIo(IOperation io) {
        this.io = io;
    }

    // Operand ('+', '-', '/', '*')
    private char getOperand(String symbol) {
        if (symbol.indexOf('+') > 0){
            return '+';
        } else if (symbol.indexOf('-') > 0){
            return '-';
        } else if (symbol.indexOf('/') > 0){
            return '/';
        } else if (symbol.indexOf('*') > 0){
            return '*';
        } else {
            throw new Error("No such operand: " + symbol);
        }
    }

    // Reverse Polish Intonation
    private void reverse(String text){
        operand = this.getOperand(text);
        if (text.indexOf('+') > 0){
            numbers = text.split("[" + operand + "]");
        } else if (text.indexOf('-') > 0){
            numbers = text.split("[" + operand + "]");
        } else if (text.indexOf('/') > 0){
            numbers = text.split("[" + operand + "]");
        } else if (text.indexOf('*') > 0){
            numbers = text.split("[" + operand + "]");
        } else {
            throw new Error();
        }
        first = this.io.getFirst(numbers[0]);
        second = this.io.getSecond(numbers[1]);
    }

    // Main execute
    public void execute(){
        input = line.nextLine();
        switch (input.trim()){
            case "roman" : executeRoman();
            case "arab" : executeArab();
            case "exit" : System.exit(0);
        }
    }

    // Function to run roman numbers
    private int executeRoman(){
        setIo(new Roman());
        System.out.println("Write roman number");
        execute();
        reverse(input);
        System.out.println("= " +  r.decimalRoman(calc(first, second, operand)));
        return executeRoman();
    }

    // Function to run arab numbers
    private int executeArab(){
        setIo(new Arab());
        System.out.println("Write arab number");
        execute();
        reverse(input);
        System.out.println("= " + calc(first, second, operand));
        return executeArab();
    }

    // Operations for calculator
    private int calc(int first, int second, char operand) {
        switch (operand) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '/':
                return first / second;
            case '*':
                return first * second;
            default:
                System.out.println("Error, try again");
        }
        return calc(first, second, operand);
    }
}