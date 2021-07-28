package Classes.Statics;

import Classes.Statics.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static List<Integer> tokens;

    /**
     * Classes.Statics.Parser function read through the list until end and populate token list
     * @param list
     * @return
     */
    public static List<Integer> Parser(Tokenizer list) {
        int stringOfList;
        tokens = new ArrayList<>();
        while ((stringOfList = list.nextSymbol()) != Tokenizer.EOF) {
            if (stringOfList != Tokenizer.EOL) {
                tokens.add(stringOfList);
            }
        }
        return tokens;
    }
}

