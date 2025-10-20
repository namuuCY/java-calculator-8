package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Parser 단위 테스트")
class ParserTest {

    private Parser parser;

    /**
     * @BeforeEach: 각 @Test 메서드가 실행되기 직전에 항상 실행됩니다. 테스트 간의 간섭을 막기 위해(독립성을 보장하기 위해) 매번 새로운 Parser 객체를 생성합니다.
     * <p>
     * given - when - then 에서 given의 일부 역할을 합니다.
     */
    @BeforeEach
    void setup() {
        parser = new Parser();
    }

    @Test
    void singleIntegerTest() {
        // given
        String input = "1234";
        // when
        List<Integer> result = parser.parseString(input);
        // then
        assertThat(result).isEqualTo(List.of(1234));
    }

    @Test
    void commaDelimiterTest() {
        String input = "1,2,3";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void colonDelimiterTest() {
        String input = "1:2:3";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void complexDelimiterTest() {
        String input = "1:2,3";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }


    @Test
    void customDelimiterTest() {
        String input = "//;\\n1;2";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void customDelimiterTest2() {
        String input = "//;\\n1;2;3";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void customComplexDelimiterTest() {
        String input = "//;\\n4;5,6";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(4, 5, 6));
    }

    @Test
    void customComplexDelimiterTest2() {
        String input = "//;\\n4;5,6";
        List<Integer> result = parser.parseString(input);
        assertThat(result).isEqualTo(Arrays.asList(4, 5, 6));
    }

    @Test
    void valueTest() {
        String input = "0";
        assertThatThrownBy(() -> {
                    parser.parseString(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void valueTest2() {
        String input = "-1,-2";
        assertThatThrownBy(() -> {
                    parser.parseString(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
