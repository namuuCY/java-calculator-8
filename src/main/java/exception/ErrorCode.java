package exception;

public enum ErrorCode {
    TEST_CODE("테스트 메세지 입니다", "TEST_001"),
    INVALID_CUSTOM_DELIMITER_FORM("커스텀 delimiter 입력이 잘못되었습니다.", "INPUT_001"),
    INVALID_INPUT_OPERAND("피연산자는 숫자여야 합니다", "INPUT_002"),
    NON_POSITIVE_INPUT_OPERAND("피연산자가 올바르지 않습니다. 양의 정수이어야 합니다.", "INPUT_003");

    private final String message;
    private final String code;

    ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
