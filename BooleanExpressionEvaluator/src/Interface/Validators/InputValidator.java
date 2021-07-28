package Interface.Validators;

import Classes.Exceptions.SyntaxException;

import java.util.List;

public interface InputValidator {
    public void ValidateInvalidSymbol(List<Integer> tokens) throws SyntaxException;
    public void ValidateParenthesis(List<Integer> tokens) throws SyntaxException;
    public void ValidateConsecutiveAndandOR(List<Integer> list, int index) throws SyntaxException;
    public void ValidateNullEmpty(String input) throws SyntaxException;
    public void ValidateConsecutiveORandAND(List<Integer> list, int index) throws SyntaxException;
    public void ValidateConsecutiveOperators(List<Integer> list, int index) throws SyntaxException;
}
