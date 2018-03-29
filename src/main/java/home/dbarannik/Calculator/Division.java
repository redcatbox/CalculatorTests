package home.dbarannik.Calculator;

import home.dbarannik.Exceptions.UnsupportedMathOperation;

public class Division implements BinaryOperation {
    public double resultFor(double left, double right) throws UnsupportedMathOperation {
        if (right == 0) {
            throw new UnsupportedMathOperation(left + " / " + right);
        }
        return left / right;
    }
}
