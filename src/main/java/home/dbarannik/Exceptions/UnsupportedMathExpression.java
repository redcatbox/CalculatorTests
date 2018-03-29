package home.dbarannik.Exceptions;

public class UnsupportedMathExpression extends Exception {
    private String expression;

    public UnsupportedMathExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
