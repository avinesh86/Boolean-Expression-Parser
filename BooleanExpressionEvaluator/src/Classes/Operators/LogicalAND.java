package Classes.Operators;

import Classes.Statics.Tokenizer;

import java.util.List;

public class LogicalAND implements Interface.Operators.LogicalAND {
    /**
     * This is to resolve &&
     * @param list
     * @param index
     * @return a list with tokens that already resolved && operator
     */
    public List<Integer> LogicalAND(List<Integer> list, int index) {
        if (list.get(index - 1) == Tokenizer.FALSE) {
            list.set(index - 1, Tokenizer.FALSE);
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
