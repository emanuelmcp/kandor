package io.github.com.exceptions.enums;

public enum ExceptionCodes {

    // Misc Errors
    UNAUTHORIZED("ERROR_00000"),

    // Db Errors
    ALREADY_EXISTS("ERROR_00100"),
    NOT_FOUND("ERROR_00101");

    private final String code;

    ExceptionCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
