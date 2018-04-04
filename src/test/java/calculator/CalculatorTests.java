package calculator;

import home.dbarannik.Calculator.Calculator;
import home.dbarannik.Exceptions.UnsupportedBinaryOperator;
import home.dbarannik.Exceptions.UnsupportedMathOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.assertj.core.api.Assertions.*;

@RunWith(Parameterized.class)
public class CalculatorTests {

    // Parameters
    @Parameterized.Parameter(0)
    public double left;
    @Parameterized.Parameter(1)
    public double right;
    @Parameterized.Parameter(2)
    public String operator;
    @Parameterized.Parameter(3)
    public double expectedResult;

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

    /******************************
    // Addition
    ******************************/
    // Parameters
    @Parameterized.Parameters
    public static Object[][] getInputDataAddition() {
        return new Object[][]
                {
                        {1, 2, "+", 3},
                        {1.1, 2.2, "+", 3.3},
                        {-1, 2, "+", 1},
                        {1.1, -2.2, "+", -1.1},
                        {-1, -2, "+", -3}
                };
    }

    @Test
    public void additions() throws UnsupportedMathOperation {
        // arrange
//        double left = 100.0;
//        double right = 200.0;
//        String operator = "+";
//        double expectedResult = 300;

        // act
        double actualResult = calculator.calculate(left, right, operator);

        // assert
        assertThat(actualResult).isCloseTo(expectedResult, within(0.000001));
    }

//    @Test(expected = UnsupportedBinaryOperator.class)
//    public void exceptions() throws UnsupportedBinaryOperator {
//        double left = 100.0;
//        double right = 200.0;
//        String operator = "wrong";
//
//        assertThatThrownBy(() -> calculator.calculate(left, right, operator)).isInstanceOf(UnsupportedBinaryOperator.class);
//    }

//    @Test(expected = UnsupportedMathOperation.class)
//    public void exception() throws UnsupportedMathOperation {
//        double left = 100.0;
//        double right = 200.0;
//        String operator = "wrong";
//
//        assertThatThrownBy(() -> calculator.calculate(left, right, operator)).isInstanceOf(UnsupportedMathOperation.class);
//    }
}




