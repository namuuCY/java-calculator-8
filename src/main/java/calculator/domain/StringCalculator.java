package calculator.domain;

import java.util.List;

public class StringCalculator {

    private final Parser parser;
    private final Operator operator;

    public StringCalculator(Parser parser, Operator operator) {
        this.parser = parser;
        this.operator = operator;
    }

    public Integer add(String inputString) {
        List<Integer> numbers = parser.parseString(inputString);
        return operator.add(numbers);
    }
}
