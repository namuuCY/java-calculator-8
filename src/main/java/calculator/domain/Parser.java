package calculator.domain;

import calculator.exception.CustomException;
import calculator.exception.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parser {

    public List<Integer> parseString(String input) {

        if (input.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String customDelimiter = extractCustomDelimiter(input);
        String trimmedInputString = trimInputString(input, customDelimiter);
        String regexPattern = buildRegexPattern(customDelimiter);
        String[] strArray = trimmedInputString.split(regexPattern);

        return Arrays.stream(strArray)
                .map(this::parseInt)
                .toList();
    }

    private String trimInputString(String input, String customDelimiter) {
        if (Objects.isNull(customDelimiter)) {
            return input;
        }

        int newlineIndex = input.indexOf("\\n");
        return input.substring(newlineIndex + 2);
    }

    private String extractCustomDelimiter(String input) {
        int newlineIndex = input.indexOf("\\n");

        if (newlineIndex == -1) {
            return null;
        }

        if (!input.startsWith("//")) {
            throw new CustomException(ErrorCode.INVALID_CUSTOM_DELIMITER_FORM);
        }

        return input.substring(2, newlineIndex);
    }

    private String buildRegexPattern(String delimiter) {

        if (Objects.isNull(delimiter)) {
            return "[,:]"; // 기본 구분자
        }
        return "[:," + delimiter + "]";
    }

    private Integer parseInt(String numberString) {
        int value;
        try {
            value = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new CustomException(e.getMessage(), ErrorCode.INVALID_INPUT_OPERAND);
        }
        if (value < 1) {
            throw new CustomException(ErrorCode.NON_POSITIVE_INPUT_OPERAND);
        }
        return value;
    }
}
