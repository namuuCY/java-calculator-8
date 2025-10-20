package exception;

public enum ErrorCode {
    TEST_CODE("테스트 메세지 입니다", "TEST_001");

    private final String message;
    private final String code;

    ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
