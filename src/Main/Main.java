package Main;

import javax.script.ScriptException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ScriptException {
        if(args.length < 1) {
            System.out.println("Welcome applicatien calculater\r\n" +
                    "Enter: <-arab> or <-roman>");
            return;
        }

        if (args[0].equals("-arab")) {
            ArabNumber an = new ArabNumber();
            Scanner line = new Scanner(System.in);
            System.out.println("Welcome! Enter number");
            String text = line.nextLine();
            System.out.println("= " + an.arabCalc(text));
        }

        if (args[0].equals("-roman")) {
            RomanNumber rn = new RomanNumber();
            Scanner line = new Scanner(System.in);
            System.out.println("Welcome! Enter number");
            String text = line.nextLine();
            int result = rn.calculator(text);
            System.out.println("= " + rn.decimalRoman(result));
        }
    }
}
