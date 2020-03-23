package Main;

public class Start {
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Welcome application arab/roman calculator\r\n" +
                    "Enter: <-start>");
            return;
        }
        if (args[0].equals("-start")) {
            System.out.println("Choice and write mode <roman>, <arab>. Exit program <exit>");
            calculator.execute();
        } else {
            throw new Error("Unknown parser");
        }

    }
}
