package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {

        CalculatorController controller = AppConfig.init();
        controller.request();
    }
}
