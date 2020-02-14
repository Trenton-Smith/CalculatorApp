package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    private int operandValue;//create field to parse data into

    /**
     * construct operand from string token.
     */
    public Operand(String token) {
        operandValue = Integer.parseInt(token);//parses a string into an int so we can deconstruct expressions like 2+2 into individual parts
    }

    /**
     * construct operand from integer
     */
    public Operand(double value) {
        operandValue = (int)value;// cast an int from a double
    }

    /**
     * return value of operand
     */
    //public double getDoubleValue() {return operandValue;} //generic getMethod for double value
    public int getValue(){return operandValue;} //instructions in assignment PDF forces us to use an int GET method but also stipulates that we have a
                                                      //...constructor that gives a double field. Not sure if one is a type, but included a getDouble and getValue
                                                      //...to be safe

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;//if the try block is successful i.e. the token isn't something like "&" or "P", we return TRUE
    }
}
