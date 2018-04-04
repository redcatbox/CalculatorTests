package home.dbarannik.Calculator;

import home.dbarannik.Exceptions.UnsupportedMathExpression;
import home.dbarannik.Exceptions.UnsupportedBinaryOperator;
import home.dbarannik.Exceptions.UnsupportedMathOperation;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Supported expression must be:");
        System.out.println("number operator number");

        while (true) {
            // Show information
            System.out.println();
            System.out.println("Enter your expression:");

            try {
                calculator.getValidExpression();
                calculator.parseExpression();
                calculator.calculate();
            } catch (UnsupportedMathExpression uME) {
                System.err.println("Unsupported expression " + uME.getExpression());
            } catch (UnsupportedBinaryOperator uBO) {
                System.err.println("Unsupported binary operator " + uBO.getOperator());
            } catch (UnsupportedMathOperation uMO) {
                System.err.println("Unsupported math operation " + uMO.getOperation());
            }
        }
    }
}
