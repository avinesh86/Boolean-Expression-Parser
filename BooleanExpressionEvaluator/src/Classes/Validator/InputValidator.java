package Classes.Validator;

import Classes.Exceptions.SyntaxException;
import Classes.Statics.Helpers.Helper;
import Classes.Statics.Tokenizer;

import java.util.List;

public class InputValidator implements Interface.Validators.InputValidator {

    /**
     * This function validate the input by checking invalid symbols
     * @param tokens
     * @throws SyntaxException
     */
    public void ValidateInvalidSymbol(List<Integer> tokens) throws SyntaxException {
        if (tokens.contains(Tokenizer.INVALID)) {
            throw new SyntaxException("Invalid Symbols");
        }
    }

    /**
     * This function validate the input by checking number of parenthesis
     * @param tokens
     * @throws SyntaxException
     */
    public void ValidateParenthesis(List<Integer> tokens) throws SyntaxException {
        if (Helper.CountOccurrences(Tokenizer.LEFT, tokens) != Helper.CountOccurrences(Tokenizer.RIGHT, tokens)) {
            throw new SyntaxException("Invalid Number of Parenthesis");
        }
    }

    /**
     * This function validate for consecutive operators
     * @param list
     * @param index
     * @throws SyntaxException
     */
    public void ValidateConsecutiveOperators(List<Integer> list, int index) throws SyntaxException {
        if (list.size()>index + 1 && list.get(index) == Tokenizer.AND) {
            ValidateConsecutiveAndandOR(list, index);
        }
        if (list.size()>index + 1 && list.get(index) == Tokenizer.OR) {
            ValidateConsecutiveORandAND(list, index);
        }
    }

    /**
     * This function validate consecutive AND and OR
     * @param list
     * @param index
     * @throws SyntaxException
     */
    public void ValidateConsecutiveAndandOR(List<Integer> list, int index) throws SyntaxException {
        if (list.get(index + 1) == Tokenizer.OR) {
            throw new SyntaxException("Invalid Syntax: Consecutive AND and OR");
        }
    }

    /**
     * This function validate consecutive OR and AND
     * @param list
     * @param index
     * @throws SyntaxException
     */
    public void ValidateConsecutiveORandAND(List<Integer> list, int index) throws SyntaxException {
        if (list.get(index + 1) == Tokenizer.AND) {
            throw new SyntaxException("Invalid Syntax: Consecutive OR and AND");
        }
    }

    /**
     * This function validate Null and Empty inputs
     * @param input
     * @throws SyntaxException
     */
    public void ValidateNullEmpty(String input) throws SyntaxException  {
        if (input == null || input.length() == 0) {
            throw new SyntaxException("Input is Null or Empty");
        }
    }
}
