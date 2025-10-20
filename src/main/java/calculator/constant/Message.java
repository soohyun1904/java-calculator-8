package calculator.constant;

public enum Message {
    ERROR_EMPTY_DELIMITER("[ERROR] 구분자가 비어있습니다."),
    ERROR_DELIMITER_LENGTH("[ERROR] 구분자는 1글자만 가능합니다."),
    ERROR_DELIMITER_NUMERIC("[ERROR] 구분자에 숫자를 사용할 수 없습니다."),
    NEGATIVE_NOT_ALLOWED("[ERROR] 음수는 허용되지 않습니다."),
    NUMBER_PARSE_ERROR("[ERROR] 숫자로 변환할 수 없습니다."),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
