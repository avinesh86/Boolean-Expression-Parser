package Classes.Operators;

import Classes.Statics.Tokenizer;

import java.util.List;

public class LogicalOR implements Interface.Operators.LogicalOR {
    /**
     * This resolve ||
     * @param list
     * @param index
     * @return a list with tokens that already resolved || operator
     */
    public List<Integer> LogicalOR(List<Integer> list, int index) {
        if (list.get(index - 1) == Tokenizer.TRUE) {
            list.set(index - 1, Tokenizer.TRUE);
        } else if (list.get(index + 2) == Tokenizer.TRUE) {
            list.set(index - 1, Tokenizer.TRUE);
        } else {
            list.set(index - 1, Tokenizer.FALSE);
        }
        list.remove(index);
        list.remove(index);
        list.remove(index);
        return list;
    }
}
