package Classes.Statics.Helpers;

import Classes.Statics.Tokenizer;

import java.util.List;

public class Helper {

    /**
     * This is a helper function that count the number of right parenthesis in the input
     * @param list
     * @return the index of the right parenthesis
     */
    public static int GetRightCounterIndex(List<Integer> list) {
        int leftCounter = 0;
        int rightCounter = 0;
        int rightIndex = 0;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) == Tokenizer.LEFT) {
                leftCounter++;
            } else if (list.get(index) == Tokenizer.RIGHT) {
                rightIndex = index;
                rightCounter++;

                if (leftCounter == rightCounter) {
                    break;
                }
            }
        }
        return rightIndex;
    }

    /**
     * This function count number of given operator
     * @param operator
     * @param list
     * @return the number of occurrences
     */
    public static int CountOccurrences(int operator, List<Integer> list) {
        int counter = 0;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) == operator) {
                counter++;
            }
        }
        return counter;
    }
}
