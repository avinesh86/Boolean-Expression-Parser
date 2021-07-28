package Classes.Operators;

import Classes.Exceptions.SyntaxException;
import Classes.Statics.Tokenizer;
import Classes.Validator.NotValidator;

import java.util.List;

public class NOT extends NotValidator implements Interface.Operators.NOT{
    /**
     * NOT function evaluates expressions that contains ! symbol
     * @param list
     * @param index
     * @return a list with tokens that already resolved ! operator
     * @throws SyntaxException
     */
    public List<Integer> NOT(List<Integer> list, int index) throws SyntaxException {

        ValidateConsecutiveOperator(list, index);

        ValidateNotBetweenBooleans(list, index);

        if (list.get(index - 1) == Tokenizer.NOT && list.get(index) != Tokenizer.NOT) {
            list.remove(index - 1);
            list.set(index - 1, (list.get(index - 1) == Tokenizer.TRUE ? Tokenizer.FALSE : Tokenizer.TRUE));
        } else if (list.get(index - 1) == Tokenizer.NOT && list.get(index) == Tokenizer.NOT) {
            list.remove(index - 1);
            list.remove(index - 1);
        }
        return list;
    }

}
