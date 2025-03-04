package spring.api.springcore.exception;

public enum ErrorCode {
    UNCATEGORIZE_EXCEPTION(9999,"Uncategorized existed"),
    INVALID_KEY(1001,"Invalid message key"),
    USER_EXISTED(1002,"User existed"),
    USERNAME_INVALID(1003,"username must at least 3 characters"),
    INVALID_PASSWORD(1004,"Password must be at least 6 characters")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
