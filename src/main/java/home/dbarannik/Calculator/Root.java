package home.dbarannik.Calculator;

import home.dbarannik.Exceptions.UnsupportedMathOperation;

public class Root implements BinaryOperation {
    public double resultFor(double left, double right) throws UnsupportedMathOperation {
        if (left < 0) {
            throw new UnsupportedMathOperation(left + " root " + right);
        }
        return Math.pow(left, 1.0/right);
    }
}
