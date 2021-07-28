package Classes.Validator;

import Classes.Exceptions.SyntaxException;
import Classes.Statics.Tokenizer;

import java.util.List;

public class NotValidator implements Interface.Validators.NotValidator {
    public void ValidateConsecutiveOperator(List<Integer> list, int index) throws SyntaxException{
        if (list.get(index) == Tokenizer.NOT) {
            if ((list.get(index + 1) == Tokenizer.AND || list.get(index + 1) == Tokenizer.OR)) {
                throw new SyntaxException("Invalid Syntax: Consecutive OR, AND with NOT");
            }
        }
    }

    public void ValidateNotBetweenBooleans(List<Integer> list, int index) throws SyntaxException {
        if (list.get(index) == Tokenizer.NOT) {
            if ((list.get(index - 1) == Tokenizer.TRUE || list.get(index - 1) == Tokenizer.FALSE)
                    && (list.get(index + 1) == Tokenizer.TRUE || list.get(index + 1) == Tokenizer.FALSE)) {
                throw new SyntaxException("Invalid Syntax: ! cannot be in between two booleans");
            }
        }
    }
}
