package exception;

public class CustomException extends IllegalArgumentException {

    private String originalExceptionMessage;


    public CustomException(String originalExceptionMessage, ErrorCode errorCode) {
        super();
    }

    public CustomException(ErrorCode errorCode) {
        super();
    }

}
