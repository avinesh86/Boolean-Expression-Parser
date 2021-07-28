package Classes.Main;

import Classes.Evaluator.Evaluator;
import Classes.Exceptions.SyntaxException;

public class BooleanEvaluator {
    /**
     * Red color for displaying errors.
     */
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Evaluate test inputs.
     */
    public static void main(String[] args) {
        // Input expression strings.
        String[] inputs = {
                "true & | ! true",
                "true ! & | true",
                "true | ! & true",
                "true ! | & true",
                "true | & true",
                "true & | true",
                "true & ! false",
                "true & ((true | false) & !(true & false))",
                "true",
                "false",
                "(true)",
                "(false)",
                "!true",
                "!false",
                "!!true",
                "!!false",
                "!(!true)",
                "!(!false)",
                "true & false",
                "true | false",
                "true & false | true",
                "true & false | true & false",
                "!true & false",
                "!true | false",
                "!(true & false)",
                "!(true | false)",
                "(true & false) | (true | false)",
                "!(true & false) | !(true | false)",
                "!(!true & !(true | (false | true)))",
                "!(!true & !(true | (false | true)))",
                "(!(!(true | (false | !(true & false)) | false)))",
                "(!(!(true & (false | !(true & false) & false))))",
                "true $",
                "& true",
                "true || false",
                "true || true",
                "true ! false",
                "true && false",
                "true && true",
                "false && true",
                "true)",
                "(true",
                "true &|",
                null,
                "",
                "12346",
                "wertyui",
                "!@#$%^Z&Z&()",
                "(!|)"
        };

        // Evaluate each expression.
        Evaluator evaluator = new Evaluator();

        for (String input : inputs) {
            try {
                boolean result = evaluator.evaluate(input);
                System.out.println(input + " = " + result);
            } catch (SyntaxException e) {
                System.out.println(ANSI_RED + "Syntax error in '" + input + "' - " + e.getMessage() + ANSI_RESET);
            }
        }
    }
}
