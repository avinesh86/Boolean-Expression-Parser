package Classes;

import Classes.Exceptions.SyntaxException;
import Classes.Helpers.Helper;
import Classes.Operators.*;
import Classes.Statics.Parser;
import Classes.Statics.Tokenizer;
import Classes.Validator.InputValidator;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Evaluator extends InputValidator {
    /**
     * This is the main evaluate function
     * @param input
     * @return the final result - true or false
     * @throws SyntaxException
     */
    public boolean evaluate(String input) throws SyntaxException {

        ValidateNullEmpty(input);
        Tokenizer tokenizer = new Tokenizer(new ByteArrayInputStream(input.getBytes()));
        List<Integer> tokens = Parser.Parser(tokenizer);
        ValidateInvalidSymbol(tokens);
        ValidateParenthesis(tokens);
        return ReturnFinalAnswer(EvaluateFullExpression(tokens));
    }

    /**
     * This converts the final token in to a boolean
     * @param answer
     * @return the final answer
     */
    public boolean ReturnFinalAnswer(List<Integer> answer) throws SyntaxException{
        if (!answer.isEmpty() && answer.size() < 2) {
            if (answer.get(0) == Tokenizer.TRUE) {
                return true;
            } else if (answer.get(0) == Tokenizer.FALSE) {
                return false;
            }
        }
        throw new SyntaxException("Invalid Answer");
    }

    /**
     * This function evaluates expressions with parenthesis
     * @param list
     * @return a simplified expression as in a list
     * @throws SyntaxException
     */
    public List<Integer> AdvancedExpressionResolver(List<Integer> list) throws SyntaxException {
        List<Integer> simplifiedList;
        List<Integer> tempList = list;
        while (tempList.contains(Tokenizer.LEFT)) {
            List<Integer> subListLeft;
            List<Integer> subListRight = new ArrayList<>();
            simplifiedList = EvaluateFullExpression(list.subList(list.indexOf(Tokenizer.LEFT) + 1,
                    Helper.GetRightCounterIndex(list)));
            if (Helper.GetRightCounterIndex(list) != list.size() - 1) {
                subListRight = list.subList(Helper.GetRightCounterIndex(list) + 1, list.size());
            }
            subListLeft = list.subList(0, list.indexOf(Tokenizer.LEFT));
            tempList = new ArrayList<>();
            tempList.addAll(subListLeft);
            tempList.addAll(simplifiedList);
            if (subListRight != null && !subListRight.isEmpty()) {
                tempList.addAll(subListRight);
            }
            list = tempList;
        }
        return list;
    }

    /**
     * This is a recursive function that evaluate the full expression until receive the final answer
     * @param list
     * @return
     * @throws SyntaxException
     */
    public List<Integer> EvaluateFullExpression(List<Integer> list) throws SyntaxException {
        List<Integer> simplifiedTokenList = new ArrayList<>();
        if (list.contains(Tokenizer.LEFT)) {
            simplifiedTokenList = EvaluateFullExpression(AdvancedExpressionResolver(list));
        } else {
            if (list.size() < 3) {
                simplifiedTokenList = EvaluateSimpleExpression(list);
            } else {
                for (int index = 1; index < list.size(); index++) {
                    list = new NOT().NOT(list, index);
                }
                for (Integer operator: Tokenizer.OPERATOR_PRECEDENCE) {
                    for (int index = 1; index < list.size(); index++) {
                        ValidateConsecutiveOperators(list, index, operator);
                        if(operator == list.get(index)){

                            if (list.get(index) == Tokenizer.AND && list.get(index + 1) == Tokenizer.AND) {
                                list = new LogicalAND().LogicalAND(list, index);
                            } else if (list.get(index) == Tokenizer.OR && list.get(index + 1) == Tokenizer.OR) {
                                list = new LogicalOR().LogicalOR(list, index);
                            } else if ((list.get(index) == Tokenizer.OR && list.get(index + 1) == Tokenizer.AND)
                                    || (list.get(index) == Tokenizer.AND && list.get(index + 1) == Tokenizer.OR)) {
                                throw new SyntaxException("Invalid Syntax: Consecutive OR and AND");
                            } else if (list.get(index) == Tokenizer.AND) {
                                list = new BitwiseAND().BitwiseAND(list, index);
                            } else if (list.get(index) == Tokenizer.OR) {
                                list = new BitwiseOR().BitwiseOR(list, index);
                            }
                        }
                    }
                }
                simplifiedTokenList.addAll(list);
            }
        }
        return simplifiedTokenList;
    }

    /**
     * This function process simple expression where it has less than 3 operators and booleans
     * @param list
     * @return an answer token in a list
     * @throws SyntaxException
     */
    public List<Integer> EvaluateSimpleExpression(List<Integer> list) throws SyntaxException {
        List<Integer> simplifiedTokenList = new ArrayList<>();
        if (list.size() == 1) {
            switch (list.get(0)) {
                case Tokenizer.TRUE:
                    simplifiedTokenList.add(Tokenizer.TRUE);
                    break;
                case Tokenizer.FALSE:
                    simplifiedTokenList.add(Tokenizer.FALSE);
                    break;
                default:
                    throw new SyntaxException("Invalid symbol or character in the expression");
            }
        } else if (list.size() == 2) {
            if (list.get(0) == Tokenizer.NOT) {
                switch (list.get(1)) {
                    case Tokenizer.TRUE:
                        simplifiedTokenList.add(Tokenizer.FALSE);
                        break;
                    case Tokenizer.FALSE:
                        simplifiedTokenList.add(Tokenizer.TRUE);
                        break;
                    default:
                        throw new SyntaxException("Invalid operator or argument");
                }
            } else {
                throw new SyntaxException("Invalid argument");
            }
        }
        return simplifiedTokenList;
    }
}
