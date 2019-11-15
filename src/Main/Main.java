package Main;

import java.util.Scanner;

public class Main {
    private static Scanner line = new Scanner(System.in);

    private String x, y, z, operation;
    private double result;

    private void operation(String x, String y){
        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        switch (operation) {
            case "+":
                result = a + b;
                System.out.println(x + " " + operation + " " + y + " = " + result);
                return;
            case "-":
                result = a - b;
                System.out.println(x + " " + operation + " " + y + " = " + result);
                return;
            case "*":
                result = a * b;
                System.out.println(x + " " + operation + " " + y + " = " + result);
                return;
            case "/":
            default:
                if (b == 0) {
                    System.out.println("You cannot divide by zero");
                    break;
                } else {
                    result = a / b;
                    System.out.println(x + " " + operation + " " + y + " = " + result);
                }
        }
    }

    private String calculator() {
        System.out.print("Enter x >> ");
        x = line.nextLine();
        if (x.matches("[0-9]+")){
            System.out.println("Well done");
        } else {
            System.out.println("Error enter number. Let's try again");
            return x = calculator();
        }

        while (true) {
            System.out.print("Enter operation >> ");
            operation = line.nextLine();

            System.out.print("Enter y >> ");
            y = line.nextLine();
            if (y.matches("[0-9]+")){
                System.out.println("Well done");
            } else {
                System.out.println("Error enter number. Let's try again");
                return y = calculator();
            }

            System.out.print("Enter symbol ('C', '=') >> ");
            z = line.nextLine();

            if ((z.charAt(0) >= '0' && z.charAt(0) <= '9') || z.charAt(0) == '.') {

                if (!operation.equals("")) {
                    y = y + z;
                } else {
                    x = x + z;
                }
                System.out.println(x + operation + y);

            } else if (z.charAt(0) == 'C') {
                x = operation = y = "";
                System.out.println(x + operation + y);
                return x = calculator();

            } else if (z.charAt(0) == '=') {
                operation(x, y);
                x = Double.toString(result);
                operation = y = "";

            } else {

                if (operation.equals("") || y.equals("")) {
                    operation = z;

                } else {
                    operation(x, y);
                    x = Double.toString(result);
                    operation = z;
                    y = "";
                }
                System.out.println(x + " " + operation + " " + y);
            }
        }
    }


    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Welcome applicatien calculater\r\n" +
                    "Enter: <-start>");
            return;
        }
        Main main = new Main();
        if (args[0].equals("-start")) {
            main.calculator();
        }
    }
}
