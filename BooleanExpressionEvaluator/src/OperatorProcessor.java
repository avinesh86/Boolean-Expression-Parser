import java.util.List;

public class OperatorProcessor {

    /**
     * NOT function evaluates expressions that contains ! symbol
     * @param list
     * @param index
     * @return a list with tokens that already resolved ! operator
     * @throws SyntaxException
     */
    public static List<Integer> NOT(List<Integer> list, int index) throws SyntaxException {
        if (list.get(index) == Tokenizer.NOT) {
            if ((list.get(index - 1) == Tokenizer.AND || list.get(index - 1) == Tokenizer.OR)
                    && (list.get(index + 1) == Tokenizer.AND || list.get(index + 1) == Tokenizer.OR)) {
                throw new SyntaxException("Invalid Syntax: Consecutive OR, AND with NOT");
            }
        }
        if (list.get(index) == Tokenizer.NOT) {
            if ((list.get(index - 1) == Tokenizer.TRUE || list.get(index - 1) == Tokenizer.FALSE)
                    && (list.get(index + 1) == Tokenizer.TRUE || list.get(index + 1) == Tokenizer.FALSE)) {
                throw new SyntaxException("Invalid Syntax: NOT operator cannot be in between two booleans");
            }
        }
        if (list.get(index - 1) == Tokenizer.NOT && list.get(index) != Tokenizer.NOT) {
            list.remove(index - 1);
            list.set(index - 1, (list.get(index - 1) == Tokenizer.TRUE ? Tokenizer.FALSE : Tokenizer.TRUE));
        } else if (list.get(index - 1) == Tokenizer.NOT && list.get(index) == Tokenizer.NOT) {
            list.remove(index - 1);
            list.remove(index - 1);
        }
        return list;
    }

    /**
     * This is to resolve &&
     * @param list
     * @param index
     * @return a list with tokens that already resolved && operator
     */
    public static List<Integer> LogicalAND(List<Integer> list, int index) {
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

    /**
     * This resolve ||
     * @param list
     * @param index
     * @return a list with tokens that already resolved || operator
     */
    public static List<Integer> LogicalOR(List<Integer> list, int index) {
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

    /**
     * This resolve |
     * @param list
     * @param index
     * @return a list with tokens that already resolved | operator
     */
    public static List<Integer> BitwiseOR(List<Integer> list, int index) {
        if (list.get(index - 1) == Tokenizer.TRUE) {
            list.set(index - 1, Tokenizer.TRUE);
        } else if (list.get(index - 1) == Tokenizer.FALSE) {
            if (list.get(index + 1) == Tokenizer.TRUE) {
                list.set(index - 1, Tokenizer.TRUE);
            } else {
                list.set(index - 1, Tokenizer.FALSE);
            }
        }
        list.remove(index);
        list.remove(index);
        return list;
    }

    /**
     * This resolve &
     * @param list
     * @param index
     * @return a list with tokens that already resolved & operator
     */
    public static List<Integer> BitwiseAND(List<Integer> list, int index) {
        if (list.get(index - 1) == Tokenizer.TRUE) {
            if (list.get(index + 1) == Tokenizer.TRUE) {
                list.set(index - 1, Tokenizer.TRUE);
            } else {
                list.set(index - 1, Tokenizer.FALSE);
            }
        } else if (list.get(index - 1) == Tokenizer.FALSE) {
            list.set(index - 1, Tokenizer.FALSE);
        }
        list.remove(index);
        list.remove(index);
        return list;
    }

}
