package Interface.Validators;

import Classes.Exceptions.SyntaxException;

import java.util.List;

public interface NotValidator {
    public void ValidateConsecutiveOperator(List<Integer> list, int index) throws SyntaxException;
    public void ValidateNotBetweenBooleans(List<Integer> list, int index) throws SyntaxException;
}
