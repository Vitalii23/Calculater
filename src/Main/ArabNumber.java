package Main;

public class ArabNumber {

    public int arabCalc(String text) {
        int result = 0;
        String[] numbers;
        if (text.indexOf('+') > 0){
            numbers = text.split("[+]");
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else if(text.indexOf('-') > 0){
            numbers = text.split("[-]");
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else if(text.indexOf('/') > 0){
            numbers = text.split("[/]");
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else if(text.indexOf('*') > 0){
            numbers = text.split("[*]");
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else {
            System.out.println("Error, try again");
        }
        return result;
    }
}
