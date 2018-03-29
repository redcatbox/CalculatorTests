package home.dbarannik.Exceptions;

public class UnsupportedMathOperation extends Exception {
    private String operation;

    public UnsupportedMathOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
