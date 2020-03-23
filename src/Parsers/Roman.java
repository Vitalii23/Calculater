package Parsers;

import Interface.IOperation;

public class Roman implements IOperation {
    private int a, b;

    // Convert decimal to roman number
    public String decimalRoman(int number){
        StringBuilder roman = new StringBuilder();
        while (number > 0 ){
            if (number >= 10){ roman.append("X"); number -= 10;
            } else if (number >= 9){ roman.append("IX"); number -= 9;
            } else if (number >= 5){ roman.append("V"); number -= 5;
            } else if (number >= 4){ roman.append("IV"); number -= 4;
            } else { roman.append("I"); number -= 1; }
        }
        return roman.toString();
    }

    // Convert roman number to decimal
   private int romanDecimal(char[] roman){
        int number = 0;
        int sum = 10;
        for (char c : roman) {
            switch (c) {
                case 'X':
                    number += 10;
                    if(sum < 10) { number -= 2 * sum; }
                    sum = 10;
                    break;
                case 'V':
                    number += 5;
                    if(sum < 5) { number -= 2 * sum; }
                    sum = 5;
                    break;
                case 'I':
                    number += 1;
                    if(sum < 1) { number -= 2 * sum; }
                    sum = 1;
                    break;
            }
        }
        return number;
    }

    // First roman number
    @Override
    public int getFirst(String first) {
        if (first.matches("(?i)(\\W|^)(I|II|III|IV|V|VI|VII|VIII|IX|X|)(\\W|$)")){
            a = Integer.parseInt(String.valueOf(romanDecimal(first.toCharArray())));
        } else {
            throw new NumberFormatException("These values are not valid: " + first);
        }
        return a;
    }

    // Second roman number
    @Override
    public int getSecond(String second) {
        if (second.matches("(?i)(\\W|^)(I|II|III|IV|V|VI|VII|VIII|IX|X|)(\\W|$)")){
            b = Integer.parseInt(String.valueOf(romanDecimal(second.toCharArray())));
        } else {
            throw new NumberFormatException("These values are not valid: " + second);
        }
        return b;
    }
}
