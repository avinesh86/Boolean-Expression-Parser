package Interface.Validators;

import Classes.Exceptions.SyntaxException;

import java.util.List;

public interface NotValidator {
    void ValidateConsecutiveOperator(List<Integer> list, int index) throws SyntaxException;
    void ValidateNotBetweenBooleans(List<Integer> list, int index) throws SyntaxException;
}
