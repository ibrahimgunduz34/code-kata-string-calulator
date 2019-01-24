package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before public void setup() {calculator = new StringCalculator();}

    @Test public void empty_input_string_Returns_zero() {
        Integer expected = 0;
        Integer actual = calculator.calculate("");
        assertEquals(expected, actual);
    }

    @Test public void one_single_numeric_input_return_itself() {
        assertEquals((Integer) 1, calculator.calculate("1"));
        assertEquals((Integer) 10, calculator.calculate("10"));
        assertEquals((Integer) 100, calculator.calculate("100"));
    }

    @Test public void sum_comma_separated_two_numbers() {
        assertEquals((Integer) 3, calculator.calculate("1,2"));
        assertEquals((Integer) 35, calculator.calculate("12,23"));
        assertEquals((Integer) 380, calculator.calculate("130,250"));
        assertEquals((Integer) 380, calculator.calculate("130 ,250"));
        assertEquals((Integer) 380, calculator.calculate("130, 250"));
    }

    @Test public void sum_newline_character_delimited_numbers() {
        assertEquals((Integer) 3, calculator.calculate("1\n2"));
        assertEquals((Integer) 35, calculator.calculate("12\n23"));
        assertEquals((Integer) 380, calculator.calculate("130\n250"));
        assertEquals((Integer) 380, calculator.calculate("130 \n250"));
        assertEquals((Integer) 380, calculator.calculate("130\n 250"));
    }

    @Test public void sum_numbers_with_comma_and_newline_character() {
        assertEquals((Integer) 6, calculator.calculate("1\n2,3"));
        assertEquals((Integer) 21, calculator.calculate("1\n2,3\n4\n5,6"));
        assertEquals((Integer) 21, calculator.calculate("1\n2,3\n4,5\n6"));
    }

    @Test public void ignore_numbers_greater_than_thousand() {
        assertEquals((Integer) 0, calculator.calculate("1001"));
        assertEquals((Integer) 3, calculator.calculate("1001,1,2"));
        assertEquals((Integer) 3, calculator.calculate("1001\n1,2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void singlie_invalid_value_throws_exception() {
        calculator.calculate("p");
    }

    @Test(expected = IllegalArgumentException.class)
    public void comma_separated_values_that_consist_of_valid_and_invalid_arguments() {
        calculator.calculate("p,1,2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void single_negative_value_throw_exception() {
        calculator.calculate("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void comma_separated_negative_value_throw_exception() {
        calculator.calculate("-1,2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void combined_negative_values_throw_exception() {
        calculator.calculate("-1,2\n-3");
    }
}