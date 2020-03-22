package Transport;

import RouteInterface.IOperation;

public class Arab implements IOperation {
    private int a, b;

    @Override
    public int getFirst(String first) {

        if (first.matches("^[1-9]{1}$|^10$")){
            a = Integer.parseInt(first);
        } else {
            System.out.println("Error write first number, try again");
        }
        return a;
    }

    @Override
    public int getSecond(String second) {
        if (second.matches("^[1-9]{1}$|^10$")){
            b = Integer.parseInt(second);
        } else {
            System.out.println("Error write second number, try again");
        }
        return b;
    }
}
