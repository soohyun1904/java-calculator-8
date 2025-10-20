package calculator.parser;

import java.util.List;
import java.util.regex.Pattern;

import static calculator.constant.Message.*;

public class DelimiterParser implements InputParser {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    public DelimiterParser() {
    }

    @Override
    public List<String> parser(String inputValue) {
        if(isCustomDelimiterFormat(inputValue)){
            return splitWithCustomDelimiter(inputValue);
        }
        return splitWithDefaultDelimiter(inputValue);
    }


    private static boolean isCustomDelimiterFormat(String inputValue) {
        return inputValue.startsWith(CUSTOM_PREFIX) && inputValue.contains(CUSTOM_SUFFIX);
    }

    private List<String> splitWithDefaultDelimiter(String inputValue) {
        if(inputValue.isEmpty()){
            return List.of();
        }
        return List.of(inputValue.split(DEFAULT_DELIMITERS));
    }

    private List<String> splitWithCustomDelimiter(String inputValue) {
        String delimiter = parseCustomDelimiter(inputValue);
        String numbersPart = extractNumberPart(inputValue);
        if(numbersPart.isEmpty()){
            return List.of();
        }
        return List.of(numbersPart.split(Pattern.quote(delimiter)));
    }

    private String parseCustomDelimiter(String inputValue) {
        int delimiterEndIndex = inputValue.indexOf(CUSTOM_SUFFIX);
        String delimiter = inputValue.substring(CUSTOM_PREFIX.length(), delimiterEndIndex);
        validateDelimiter(delimiter);
        return delimiter;
    }

    private String extractNumberPart(String inputValue) {
        int delimiterEndIndex = inputValue.indexOf(CUSTOM_SUFFIX);
        return inputValue.substring(delimiterEndIndex + 2);
    }

    private void validateDelimiter(String delimiter) {
        if(delimiter.isBlank()){
            throw new IllegalArgumentException(ERROR_EMPTY_DELIMITER.getMessage());
        }
        if(delimiter.length()>1){
            throw new IllegalArgumentException(ERROR_DELIMITER_LENGTH.getMessage());
        }
        if(Character.isDigit(delimiter.charAt(0))){
            throw new IllegalArgumentException(ERROR_DELIMITER_NUMERIC.getMessage());
        }
    }


}
