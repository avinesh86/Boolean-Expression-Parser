package Interface.Validators;

import Classes.Exceptions.SyntaxException;

import java.util.List;

public interface InputValidator {
    void ValidateInvalidSymbol(List<Integer> tokens) throws SyntaxException;
    void ValidateParenthesis(List<Integer> tokens) throws SyntaxException;
    void ValidateConsecutiveAndandOR(List<Integer> list, int index) throws SyntaxException;
    void ValidateNullEmpty(String input) throws SyntaxException;
    void ValidateConsecutiveORandAND(List<Integer> list, int index) throws SyntaxException;
    void ValidateConsecutiveOperators(List<Integer> list, int index) throws SyntaxException;
}
