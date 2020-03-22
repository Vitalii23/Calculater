package Main;

import RouteInterface.IOperation;

public class Calculator {
    private IOperation io;
    private int first, second, count = 0;
    private char operand;
    private String[] numbers;
    private boolean isCount;


    public void setIo(IOperation io) {
        this.io = io;
    }

    private char getOperand(String symbol) {
        for (int i = 0; i <= symbol.length() - 1; i++) {
            isCount = (symbol.charAt(i) == '+'
                    || symbol.charAt(i) == '-'
                    || symbol.charAt(i) == '/'
                    || symbol.charAt(i) == '*');
            if (isCount) { count = i; }
        }
        return symbol.charAt(count);
    }

    private void check(String text){
        if (text.indexOf('+') > 0){
            numbers = text.split("[+]");
        } else if (text.indexOf('-') > 0){
            numbers = text.split("[-]");
        } else if (text.indexOf('/') > 0){
            numbers = text.split("[/]");
        } else if (text.indexOf('*') > 0){
            numbers = text.split("[/]");
        }
        first = this.io.getFirst(numbers[0]);
        second = this.io.getSecond(numbers[1]);
    }

    public int execute(String text){
        operand = this.getOperand(text);
        check(text);
        return calc(first, second, operand);
    }


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
