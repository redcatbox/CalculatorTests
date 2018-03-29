package home.dbarannik.Exceptions;

public class UnsupportedBinaryOperator extends Exception {
    private String operator;

    public UnsupportedBinaryOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
