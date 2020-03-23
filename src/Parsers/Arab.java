package Parsers;

import Interface.IOperation;

public class Arab implements IOperation {
    private int a, b;

    // First arab number
    @Override
    public int getFirst(String first) {
        if (first.matches("^[1-9]{1}$|^10$")){
            a = Integer.parseInt(first);
        } else {
            throw new NumberFormatException("These values are not valid: " + first);
        }
        return a;
    }

    // First second number
    @Override
    public int getSecond(String second) {
        if (second.matches("^[1-9]{1}$|^10$")){
            b = Integer.parseInt(second);
        } else {
            throw new NumberFormatException("These values are not valid: " + second);
        }
        return b;
    }
}
