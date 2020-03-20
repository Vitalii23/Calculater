package Start;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Welcome application calculator\r\n" +
                    "Enter: <-start>");
            return;
        }
        if (args[0].equals("-start")) {
            Operation o = new Operation();
            o.calc();
        } else {
            System.out.println("Error start, try again");
        }
    }
}
