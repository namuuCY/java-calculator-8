package calculator.config;

import calculator.controller.CalculatorController;
import calculator.domain.Operator;
import calculator.domain.Parser;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public static CalculatorController init() {
        return new CalculatorController(
                new InputView(),
                new OutputView(),
                initStringCalculator()
        );
    }

    private static StringCalculator initStringCalculator() {
        return new StringCalculator(
                new Parser(),
                new Operator()
        );
    }
}
