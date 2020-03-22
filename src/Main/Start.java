package Main;

import Transport.Arab;
import Transport.Roman;

import java.util.Scanner;

public class Start {
    private static Calculator calculator = new Calculator();
    private static Roman r = new Roman();
    private static Scanner line = new Scanner(System.in);
    private static String input;
    private static int output;

    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("Welcome application arab/roman calculator\r\n" +
                    "Enter: <-start>");
            return;
        }
        if (args[0].equals("-roman")) {
            calculator.setIo(new Roman());
            System.out.println("Welcome! Write roman number");
            input = line.nextLine();
            output = calculator.execute(input);
            System.out.println( "= " + r.decimalRoman(output));
        } else if (args[0].equals("-arab")){
            calculator.setIo(new Arab());
            System.out.println("Welcome! Write arab number");
            input = line.nextLine();
            output = calculator.execute(input);
            System.out.println( "= " + output);
        } else {
            throw new Error("Unknown parser");
        }

    }
}
