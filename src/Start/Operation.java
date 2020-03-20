package Start;

import java.util.Scanner;

public class Operation {
    private static Scanner line = new Scanner(System.in);
    private RomanNumber rn = new RomanNumber();
    private int result = 0;
    private String[] numbers;
    private String text;

    public int calc() {
            System.out.println("Enter number");
            text = line.nextLine();

            try {
                if (text.indexOf('+') > 0) {
                    numbers = text.split("[+]");

                    // Arab number
                    if (numbers[0].matches("\\d+") || numbers[1].matches("\\d+")) {
                        result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
                        System.out.println("= " + result);

                        // Roman number
                    } else if (numbers[0].matches("\\w+") || numbers[1].matches("\\w+")) {
                        result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                                + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
                        System.out.println("= " + rn.decimalRoman(result));

                    } else {
                        System.out.println("Error write number, try again");
                    }

                } else if (text.indexOf('-') > 0) {
                    numbers = text.split("[-]");

                    // Arab number
                    if (numbers[0].matches("\\d+") && numbers[1].matches("\\d+")) {
                        result = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                        System.out.println("=" + result);

                        // Roman number
                    } else if (numbers[0].matches("\\w+") && numbers[1].matches("\\w+")) {
                        result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                                - Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
                        System.out.println("=" + rn.decimalRoman(result));

                    } else {
                        System.out.println("Error write number, try again");
                    }

                } else if (text.indexOf('/') > 0) {
                    numbers = text.split("[/]");

                    // Arab number
                    if (numbers[0].matches("\\d+") && numbers[1].matches("\\d+")) {
                        result = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
                        System.out.println("= " + result);

                        // Roman number
                    } else if (numbers[0].matches("\\w+") && numbers[1].matches("\\w+")) {
                        result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                                / Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
                        System.out.println("=" + rn.decimalRoman(result));

                    } else {
                        System.out.println("Error write number, try again");
                    }

                } else if (text.indexOf('*') > 0) {
                    numbers = text.split("[*]");

                    // Arab number
                    if (numbers[0].matches("\\d+") && numbers[1].matches("\\d+")) {
                        result = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                        System.out.println("=" + result);

                        // Roman number
                    } else if (numbers[0].matches("\\w+") && numbers[1].matches("\\w+")) {
                        result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                                * Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
                        System.out.println("=" + rn.decimalRoman(result));

                    } else {
                        System.out.println("Error write number, try again");
                    }

                } else if (text.equals("exit")){
                    System.exit(0);

                } else  {
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
