package kata;

import java.util.Arrays;

public class StringCalculator {
    private static Integer extractLineTotal(String line) {
        return Arrays
                .stream(line.split(","))
                .map(String::trim)
                .map(StringCalculator::parseValue)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Integer parseValue(String element) {
        try {
            Integer value = Integer.parseInt(element);
            if (value < 0) {
                throw new IllegalArgumentException("The input value must be positive integer value");
            } else if (value > 1000) {
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The input string must be consist by numbers and proper separators");
        }
    }

    public Integer calculate(String input) {
        String cleanedInput = input.trim();
        if (cleanedInput.isEmpty()) {
            return 0;
        }

        if (!cleanedInput.contains("\n") && !cleanedInput.contains(",")) {
            return parseValue(cleanedInput);
        }

        return Arrays
                .stream(cleanedInput.split("\n"))
                .map(StringCalculator::extractLineTotal).mapToInt(Integer::intValue)
                .sum();
    }
}
