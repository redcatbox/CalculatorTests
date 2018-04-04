package home.dbarannik.Calculator;

import home.dbarannik.ConsoleReader.ConsoleReader;
import home.dbarannik.Exceptions.UnsupportedBinaryOperator;
import home.dbarannik.Exceptions.UnsupportedMathExpression;
import home.dbarannik.Exceptions.UnsupportedMathOperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    final static Pattern VALID_EXPRESSION = Pattern.compile("^\\-?[0-9]+\\.?[0-9]*\\s[a-z\\+\\-\\*\\/\\^]+\\s\\-?[0-9]+\\.?[0-9]*$");
    double left;
    double right;
    double result;
    String operator;
    private String expression;
    private ConsoleReader reader = new ConsoleReader();
    BinaryOperation operation;

    public void getValidExpression() throws UnsupportedMathExpression {
        while (true) {
            expression = "";
            expression = reader.getInputString();
            Matcher mat = VALID_EXPRESSION.matcher(expression);
            if (mat.matches()) {
                break;
            } else {
                throw new UnsupportedMathExpression(expression);
            }
        }
    }

    public void parseExpression() throws UnsupportedBinaryOperator {
        String[] arguments = expression.split(" ");
        left = Double.parseDouble(arguments[0]);
        operator = arguments[1];
        right = Double.parseDouble(arguments[2]);
    }

    public double calculate() throws UnsupportedMathOperation{
        result = operation.resultFor(left, right);
        System.out.println( left + " " + operator + " " + right + " = " + result);
        return result;
    }

    public double calculate(double left, double right, String operator) throws UnsupportedMathOperation{
        this.left = left;
        this.right = right;
        this.operator = operator;
        result = operation.resultFor(left, right);
        return result;
    }

    public void getOperationFor() throws UnsupportedBinaryOperator {
        if ("+".equals(operator)) {
            operation = new Addition();
        } else if ("-".equals(operator)) {
            operation = new Subtraction();
        } else if ("*".equals(operator)) {
            operation = new Multiplication();
        } else if ("/".equals(operator)) {
            operation = new Division();
        } else if ("^".equals(operator)) {
            operation = new Power();
        } else if ("log".equals(operator)) {
            operation = new Logarithm();
        } else if ("root".equals(operator)) {
            operation = new Root();
        } else {
            throw new UnsupportedBinaryOperator(operator);
        }
    }
}
