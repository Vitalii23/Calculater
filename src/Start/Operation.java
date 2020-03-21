package Start;

import java.util.Scanner;

public class Operation {
    private static Scanner line = new Scanner(System.in);
    private RomanNumber rn = new RomanNumber();
    private int result = 0, count = 0;
    private String[] numbers;
    private String text;
    private boolean isCount;

    // Addition
    private void calcAdd(){
        // Arab number
        if (isNumber()) {
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            System.out.println("= " + result);
            // Roman number
        } else if (isSymbol()) {
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
            System.out.println("= " + rn.decimalRoman(result));
        } else {
            System.out.println("Error write number, try again");
        }
    }

    // Subtraction
    private void calcSubt(){
        // Arab number
        if (isNumber()) {
            result = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
            System.out.println("=" + result);
            // Roman number
        } else if (isSymbol()) {
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    - Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
            System.out.println("=" + rn.decimalRoman(result));
        } else {
            System.out.println("Error write number, try again");
        }
    }

    // Divide
    private void calcDiv(){
        // Arab number
        if (isNumber()) {
            result = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
            System.out.println("= " + result);
            // Roman number
        } else if (isSymbol()) {
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    / Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
            System.out.println("=" + rn.decimalRoman(result));
        } else {
            System.out.println("Error write number, try again");
        }
    }

    // Multiply
    private void calcMult(){
        // Arab number
        if (isNumber()) {
            result = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
            System.out.println("=" + result);
            // Roman number
        } else if (isSymbol()) {
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    * Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
            System.out.println("=" + rn.decimalRoman(result));

        } else {
            System.out.println("Error write number, try again");
        }
    }

    // Character count
    private int counter(String text) {
        for (int i = 0; i <= text.length() - 1; i++) {
            isCount = (text.charAt(i) == '+'
                    || text.charAt(i) == '-'
                    || text.charAt(i) == '/'
                    || text.charAt(i) == '*');
            if (isCount) { count = i; }
        }
        return count;
    }

    // Check if there is a number
    private boolean isNumber(){
        return numbers[0].matches("\\d+") || numbers[1].matches("\\d+");
    }

    // Check if there is a symbol
    private boolean isSymbol(){
        return numbers[0].matches("\\w+") || numbers[1].matches("\\w+");
    }

    // Calculator operation
    public int calc() {
            System.out.println("Enter number");
            text = line.nextLine();
        try {
                switch (text.charAt(counter(text))) {
                    case '+':
                        numbers = text.split("[+]");
                        calcAdd();
                        break;
                    case '-':
                        numbers = text.split("[-]");
                        calcSubt();
                        break;
                    case '/':
                        numbers = text.split("[/]");
                        calcDiv();
                        break;
                    case '*':
                        numbers = text.split("[*]");
                        calcMult();
                        break;
                    default:
                        if (text.equals("exit")) {
                            System.exit(0);
                        }
                        System.out.println("Error, try again");
            }
        } catch (NumberFormatException ex) {
            System.err.println("Error: " + ex);
            System.out.println("These values are not valid: " + text);
            return result;

        } catch (ArithmeticException ex) {
            System.err.println("Error:" + ex);
            System.out.println("Can not be divided by zero");
            return result;
        }

        return calc();
    }

}
