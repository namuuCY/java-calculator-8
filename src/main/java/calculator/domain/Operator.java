package calculator.domain;

import java.util.List;

public class Operator {

    public Integer add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
