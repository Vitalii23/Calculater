package Start;

public class RomanNumber {

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

    int romanDecimal(char[] roman){

        int number = 0;
        int sum = 10;

        for (char c : roman) {
            switch (c) {
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
}
