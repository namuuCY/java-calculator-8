package calculator.view;


public class OutputView {

    public void showOutput(Integer answer) {

        String outputMessage = createOutputMessage(answer);
        System.out.println(outputMessage);
    }

    private String createOutputMessage(Integer answer) {
        StringBuilder sb = new StringBuilder();
        sb.append(ViewMessages.OUTPUT_ANNOUNCEMENT.getMessage());
        sb.append(answer);
        return sb.toString();
    }
}
