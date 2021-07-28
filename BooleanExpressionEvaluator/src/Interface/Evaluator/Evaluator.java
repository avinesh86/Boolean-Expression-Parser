package Interface.Evaluator;

import Classes.Exceptions.SyntaxException;

import java.util.List;

public interface Evaluator {
    boolean evaluate(String input) throws SyntaxException;
    boolean ReturnFinalAnswer(List<Integer> answer) throws SyntaxException;
    List<Integer> AdvancedExpressionResolver(List<Integer> list) throws SyntaxException;
    List<Integer> EvaluateFullExpression(List<Integer> list) throws SyntaxException;
    List<Integer> EvaluateSimpleExpression(List<Integer> list) throws SyntaxException;
}
