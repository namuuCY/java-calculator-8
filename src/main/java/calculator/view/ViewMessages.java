package calculator.view;


public enum ViewMessages {
    INPUT_ANNOUNCEMENT("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_ANNOUNCEMENT("결과 : ");

    private String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
