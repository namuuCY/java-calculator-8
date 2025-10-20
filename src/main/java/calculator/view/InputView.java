package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String scanInput() {
        System.out.println(ViewMessages.INPUT_ANNOUNCEMENT.getMessage());
        return Console.readLine();
    }
}
