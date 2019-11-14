package Main;

import java.util.Scanner;

public class Main {
    static Scanner line = new Scanner(System.in);

    String x, y, z, operation;

    public void calculator() {
        while (true) {
            System.out.print("Enter x >> ");
            x = line.nextLine();
            System.out.print("Enter operation >> ");
            operation = line.nextLine();
            System.out.print("Enter y >> ");
            y = line.nextLine();
            System.out.print("Enter action ('C', '=') >> ");
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
            } else if (z.charAt(0) == '=') {
                double result;
                if (operation.equals("+")) {
                    result = (Double.parseDouble(x) + Double.parseDouble(y));
                } else if (operation.equals("-")) {
                    result = (Double.parseDouble(x) - Double.parseDouble(y));
                } else if (operation.equals("/")) {
                    result = (Double.parseDouble(x) / Double.parseDouble(y));
                } else {
                    result = (Double.parseDouble(x) * Double.parseDouble(y));
                }
                System.out.println(x + " " + operation + " " + y + " = " + result);
                x = Double.toString(result);
                operation = y = "";
            } else {
                if (operation.equals("") || y.equals("")) {
                    operation = z;
                } else {
                    double result;
                    if (operation.equals("+")) {
                        result = (Double.parseDouble(x) + Double.parseDouble(y));
                    } else if (operation.equals("-")) {
                        result = (Double.parseDouble(x) - Double.parseDouble(y));
                    } else if (operation.equals("/")) {
                        result = (Double.parseDouble(x) / Double.parseDouble(y));
                    } else {
                        result = (Double.parseDouble(x) * Double.parseDouble(y));
                    }

                    x = Double.toString(result);

                    operation = z;

                    y = "";
                }
                System.out.println(x + " " + operation + " " + y);
            }
        }



        /*if (operation.equals("+")) {
                result = x + y;
            } else if (operation.equals("-")) {
                result = x - y;
            } else if (operation.equals("*")) {
                result = x * y;
            } else if (operation.equals("/")) {
                result = x / y;
            } else {
                System.out.print("Operator not recognized");
            }
            System.out.print("First variable equal = " + result + "\r\n");
            System.out.print("Enter y >> ");
            result += y;
            System.out.println(result);*/


        /*switch (operation) {
            case "+":
                result = x + y;
                System.out.println(x + " + " + y + " = " + result);
                while (result != 0) {
                    System.out.print("First variable equal = " +result + "\r\n");
                    System.out.print("Enter z >> ");
                    z = line.nextDouble();
                    result += z;
                    System.out.println(result);
                }
                break;
            case "-":
                result = x - y;
                System.out.println(x + " - " + y + " = " + result);
                break;
            case "*":
                result = x * y;
                System.out.println(x + " * " + y + " = " + result);
                break;
            case "/":
                if (y == 0) {
                    System.out.println("You cannot divide by zero");
                    break;
                } else {
                    result = x / y;
                    System.out.println(x + " / " + y + " = " + result);
                    break;
                }
            default:
                System.out.println("No operation");
        }*/
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
