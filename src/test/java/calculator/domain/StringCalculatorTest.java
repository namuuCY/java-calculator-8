package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("StringCalculator 단위 테스트")
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {

        Parser parser = new Parser();
        Operator operator = new Operator();

        stringCalculator = new StringCalculator(parser, operator);
    }

    @Test
    void singleIntegerTest() {
        // given
        String input = "1234";
        // when
        Integer answer = stringCalculator.add(input);
        // then
        assertThat(answer).isEqualTo(1234);
    }


    @Test
    void simpleIntegersTest() {
        String input = "1,2:34";
        Integer answer = stringCalculator.add(input);
        assertThat(answer).isEqualTo(37);
    }


    @Test
    void complexIntegersTest() {
        String input = "//-\\n1-2:34";
        Integer answer = stringCalculator.add(input);
        assertThat(answer).isEqualTo(37);
    }


}
