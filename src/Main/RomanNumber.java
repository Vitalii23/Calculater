package Main;

import java.util.Scanner;

public class RomanNumber {
    private static String text, n;
    private static int res;

    public String decimalRoman(int number){
        StringBuilder roman = new StringBuilder();
        while (number > 0 ){
            if (number >= 1000){ roman.append("M"); number -= 1000;
            } else if (number >= 900){ roman.append("CM"); number -= 900;
            } else if (number >= 500){ roman.append("D"); number -= 500;
            } else if (number >= 400){ roman.append("CD"); number -= 400;
            } else if (number >= 100){ roman.append("C"); number -= 100;
            } else if (number >= 90){ roman.append("XC"); number -= 90;
            } else if (number >= 50){ roman.append("C"); number -= 50;
            } else if (number >= 40){ roman.append("XL"); number -= 40;
            } else if (number >= 10){ roman.append("X"); number -= 10;
            } else if (number >= 9){ roman.append("IX"); number -= 9;
            } else if (number >= 5){ roman.append("V"); number -= 5;
            } else if (number >= 4){ roman.append("IV"); number -= 4;
            } else { roman.append("I"); number -= 1; }
        }
        return roman.toString();
    }

    public int romanDecimal(char[] roman){
        int number = 0;
        int sum = 1000;
        for (char c : roman) {
            switch (c) {
                case 'M':
                    number += 1000;
                    if(sum < 1000) {
                        number -= 2 * sum;
                    }
                    sum = 1000;
                    break;
                case 'D':
                    number += 500;
                    if(sum < 500) {
                        number -= 2 * sum;
                    }
                    sum = 500;
                    break;
                case 'C':
                    number += 100;
                    if(sum < 100) {
                        number -= 2 * sum;
                    }
                    sum = 100;
                    break;
                case 'L':
                    number += 50;
                    if(sum < 50) {
                        number -= 2 * sum;
                    }
                    sum = 50;
                    break;
                case 'X':
                    number += 10;
                    if(sum < 10) {
                        number -= 2 * sum;
                    }
                    sum = 10;
                    break;
                case 'V':
                    number += 5;
                    if(sum < 5) {
                        number -= 2 * sum;
                    }
                    sum = 5;
                    break;
                case 'I':
                    number += 1;
                    if(sum < 1) {
                        number -= 2 * sum;
                    }
                    sum = 1;
                    break;
            }
       }
        return number;
    }

    public int calculator(String text) {
        RomanNumber rn = new RomanNumber();
        int result = 0;
        String[] numbers;
        if (text.indexOf('+') > 0){
            numbers = text.split("[+]");
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
        } else if(text.indexOf('-') > 0){
            numbers = text.split("[-]");
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
        } else if(text.indexOf('/') > 0){
            numbers = text.split("[/]");
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
        } else if(text.indexOf('*') > 0){
            numbers = text.split("[*]");
            result = Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[0].toCharArray())))
                    + Integer.parseInt(String.valueOf(rn.romanDecimal(numbers[1].toCharArray())));
        } else {
            System.out.println("Error, try again");
        }
        return result;
    }

    /*void result(String x, char symbol, String y, String result){
        System.out.println(x + " " + symbol + " " + y + " = " + result);
    }*/

    /*public static void main(String[] args) {
        RomanNumber rn = new RomanNumber();
        Scanner line = new Scanner(System.in);
        text = line.nextLine();
        res = rn.calculator(text);
        n = rn.decimalRoman(res);
        System.out.println("= " + n);
        System.out.print("Enter x >> ");
        x = line.nextLine();
        a = rn.romanDecimal(x.toCharArray());
        System.out.print("Enter symbol ('+', '-', '*', '/') >> ");
        symbol = line.nextLine().charAt(0);
        System.out.print("Enter y >> ");
        y = line.nextLine();
        b = rn.romanDecimal(y.toCharArray());
        res = rn.calculator(a, symbol, b);
        n = rn.decimalRoman(res);
        rn.result(x, symbol, y, n);
    }*/

}
