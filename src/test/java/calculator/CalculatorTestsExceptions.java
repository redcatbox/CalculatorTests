package calculator;

import home.dbarannik.Calculator.Calculator;
import home.dbarannik.Exceptions.UnsupportedBinaryOperator;
import home.dbarannik.Exceptions.UnsupportedMathOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTestsExceptions {

    // Calculator
    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Before each test");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("After each test");
        calculator = null;
    }

    @Test(expected = UnsupportedBinaryOperator.class)
    public void exceptionUnsupportedBinaryOperator() {
        String operatorEx = "wrong";
        assertThatThrownBy(() -> calculator.getOperationFor(operatorEx)).isInstanceOf(UnsupportedBinaryOperator.class);
    }

    @Test(expected = UnsupportedMathOperation.class)
    public void exceptionUnsupportedMathOperationDivide() {
        double leftEx = 1.0;
        double rightEx = 0.0;
        String operatorEx = "/";
        assertThatThrownBy(() -> calculator.calculate(leftEx, rightEx, operatorEx)).isInstanceOf(UnsupportedMathOperation.class);
    }

    @Test(expected = UnsupportedMathOperation.class)
    public void exceptionUnsupportedMathOperationRoot() {
        double leftEx = -1.0;
        double rightEx = 1.0;
        String operatorEx = "root";
        assertThatThrownBy(() -> calculator.calculate(leftEx, rightEx, operatorEx)).isInstanceOf(UnsupportedMathOperation.class);
    }
}
