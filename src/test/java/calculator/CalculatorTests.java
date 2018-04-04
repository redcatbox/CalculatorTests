package calculator;

import home.dbarannik.Calculator.Calculator;
import home.dbarannik.Exceptions.UnsupportedBinaryOperator;
import home.dbarannik.Exceptions.UnsupportedMathOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

    /******************************/
    //  Addition
    /******************************/
    // Parameters
    @Parameterized.Parameters
    public static Object[][] getInputDataAddition() {
        return new Object[][]
                {
                        // additions
                        {1, 2, "+", 3},
                        {1.1, 2.2, "+", 3.3},
                        {-1, 2, "+", 1},
                        {1.1, -2.2, "+", -1.1},
                        {-1, -2, "+", -3},

                        // subtractions
                        {2, 1, "-", 1},
                        {1.1, 2.2, "-", -1.1},
                        {-1, 2, "-", -3},
                        {1, -2, "-", 3},
                        {-1.1, -2.2, "-", 1.1},

                        // multiplications
                        {2, 2, "*", 4},
                        {-1, 2.2, "*", -2.2},
                        {1.1, -2, "*", -2.2},
                        {-1, -2, "*", 2},

                        // divisions
                        {2, 2, "/", 1},
                        {-1, 2, "/", -0.5},
                        {2.0, -1.0, "/", -2.0},
                        {-2, -1, "/", 2},

                        // powers
                        {2, 2, "^", 4},
                        {2, 0, "^", 1},
                        {2.0, -1.0, "^", 0.5},
                        {-2, 2, "^", 4},
                        {-2, -2, "^", 0.25},

                        // logs
                        {1.0, 10.0, "log", 0.0},
                        {10.0, 10.0, "log", 1.0},

                        // roots
                        {4, 2, "root", 2},
                        {4, -2, "root", 0.5},
                };
    }

    @Test
    public void operations() throws UnsupportedMathOperation, UnsupportedBinaryOperator {
        double actualResult = calculator.calculate(left, right, operator);
        assertThat(actualResult).isCloseTo(expectedResult, within(0.000001));
        System.out.println("Operation " + operator + " : " + left + " " + operator + " " + right + "; " + "act = " + actualResult + ", " + "exp = " + expectedResult);
    }

//    /******************************/
//    //    Exceptions
//    /******************************/
//    @Test(expected = UnsupportedBinaryOperator.class)
//    public void exceptionUnsupportedBinaryOperator() throws UnsupportedBinaryOperator {
//        double dataEx = 1.0;
//        String operatorEx = "wrong";
//        assertThatThrownBy(() -> calculator.calculate(dataEx, dataEx, operatorEx)).isInstanceOf(UnsupportedBinaryOperator.class);
//    }

//    @Test(expected = UnsupportedMathOperation.class)
//    public void exceptionUnsupportedMathOperation() throws UnsupportedMathOperation {
//        double leftEx = 1.0;
//        double rightEx = 0.0;
//        String operatorEx = "/";
//        assertThatThrownBy(() -> calculator.calculate(left, right, operator)).isInstanceOf(UnsupportedMathOperation.class);
//    }

//    @Test(expected = UnsupportedMathOperation.class)
//    public void exceptionUnsupportedMathOperation() throws UnsupportedMathOperation {
//        double leftEx = -1.0;
//        double rightEx = 1.0;
//        String operatorEx = "root";
//        assertThatThrownBy(() -> calculator.calculate(left, right, operator)).isInstanceOf(UnsupportedMathOperation.class);
//    }
}

// arrange
// act
// assert