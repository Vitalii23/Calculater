package Main;

import java.util.Scanner;

public class Main {
    private static Scanner line = new Scanner(System.in);

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Welcome applicatien calculater\r\n" +
                    "Enter: <-arab> or <-roman>");
            return;
        }

        if (args[0].equals("-arab")) {
            ArabNumber an = new ArabNumber();
            System.out.println("Welcome! Enter arab number");
            String text = line.nextLine();
            System.out.println("= " + an.arabCalc(text));
        } else if (args[0].equals("-roman")) {
            RomanNumber rn = new RomanNumber();
            System.out.println("Welcome! Enter roman number");
            String text = line.nextLine();
            int result = rn.calculator(text);
            System.out.println("= " + rn.decimalRoman(result));
        } else {
            System.out.println("Error, try again");
            return;
        }
    }
}
