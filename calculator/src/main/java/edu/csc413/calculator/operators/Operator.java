package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    /**
     * creates the HashMap with key/value pairs where in this case the values are subclasses of abstract class Operator
     * static is able to be used here because the map is declared in the class-level scope, not in one of its methods
     */
    static HashMap operators = new HashMap();
    static{
        operators.put(")", new RightFlag() );
        operators.put("+", new AddOperator() );
        operators.put("-", new SubtractOperator() );
        operators.put("*", new MultiplyOperator() );
        operators.put("/", new DivideOperator() );
        operators.put("^", new PowerOperator() );
        operators.put("(", new LeftFlag() );//unsure if this is the right solution yet
    }

    /**
     * retrieve the priority of an Operator
     * @return priority of an Operator as an int
     */
    public abstract int priority();//this method will be overridden in each subclass to return the proper int value

    /**
     * Abstract method to execute an operator given two operands.
     * @param operandOne first operand of operator
     * @param operandTwo second operand of operator
     * @return an operand of the result of the operation.
     */
    public abstract Operand execute(Operand operandOne, Operand operandTwo);//this method will be overridden to perform each subclass'...
                                                                            //...specific function

    /**
     * used to retrieve an operator from our HashMap.
     * This will act as out publicly facing function,
     * granting access to the Operator HashMap.
     *
     * @param token key of the operator we want to retrieve
     * @return reference to a Operator instance.
     */
    public static Operator getOperator(String token) {
        return (Operator) operators.get(token);//essentially works as our HashMap's getMethod
    }

    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     */
    public static boolean check(String token) {
        return operators.containsKey(token);//containsKey returns TRUE if token is a key corresponding to a value in the HashMap
    }
}