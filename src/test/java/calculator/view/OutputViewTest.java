package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 단위 테스트")
class OutputViewTest {

    private OutputView outputView;

    private final ByteArrayOutputStream testContents = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        outputView = new OutputView();
        // System.out의 대상을 testContents -> Stream화 해서 콘솔 교체
        System.setOut(new PrintStream(testContents));
    }

    // 테스트가 끝난 후 System.out을 원래대로 복구
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void defaultIntegerTest() {
        Integer input = 123;
        outputView.showOutput(input);
        assertThat(testContents.toString()).contains("결과 : 123");
    }


}
