package calculator.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.constant.Message.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class SeparatorTest {

    @Test
    @DisplayName("기본 구분자로 구분된 문자열을 분리한다.")
    void splitByDefaultDelimiters(){
        String input = "1,2:3,4:5";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열을 분리한다.")
    void splitByCustomDelimiters(){
        String input = "//;\\n1;2;3;4;5";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("빈 문자열은 빈 리스트를 반환한다.")
    void splitEmptyList(){
        String input = "";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("커스텀 구분자 이후 빈 문자열은 빈 리스트를 반환한다.")
    void splitWithCustomDelimitersEmptyList(){
        String input = "//;\\n";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("연속된 기본 구분자는 빈 리스트를 반환한다.")
    void splitWithConsecutiveDefaultDelimiters(){
        String input = ":::";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("연속된 커스텀 구분자는 빈 리스트를 반환한다.")
    void splitWithConsecutiveCustomDelimiters(){
        String input = "//;\\n;;;";
        List<String> result = Separator.splitByDelimiter(input);
        assertThat(result).isEmpty();
    }


    @Test
    @DisplayName("커스텀 구분자가 없으면 IllegalArgumentException 예외가 발생한다.")
    void emptyDelimiterThrowsException(){
        String input = "//\\n";
        assertThatThrownBy(() -> Separator.splitByDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_EMPTY_DELIMITER);
    }

    @Test
    @DisplayName("커스텀 구분자의 길이가 2 이상이면 IllegalArgumentException 예외 발생한다.")
    void longDelimiterThrowsException() {
        String input ="//;;\\n1;;2;;3;;";
        assertThatThrownBy(() -> Separator.splitByDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DELIMITER_LENGTH);
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자라면 IllegalArgumentException 예외 발생한다.")
    void numericDelimiterThrowsException(){
        String input = "//7\\n17273";
        assertThatThrownBy(() -> Separator.splitByDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DELIMITER_NUMERIC);
    }

}
