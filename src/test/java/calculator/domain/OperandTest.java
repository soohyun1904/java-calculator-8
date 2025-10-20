package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.constant.Message.*;
import static org.assertj.core.api.Assertions.*;

public class OperandTest {

    @Test
    @DisplayName("피연산자 문자열에서 숫자로 변환한다.")
    void convertStringToNumber(){
        String input = "1234";
        Operand result = Operand.from(input);
        assertThat(result.getValue()).isEqualTo(1234);
    }

    @Test
    @DisplayName("빈 문자열을 받으면 0으로 변환한다.")
    void convertEmptyStringToZero(){
        String input = "";
        Operand result = Operand.from(input);
        assertThat(result.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("피연산자가 int 숫자 범위를 초과했다면 IllegalArgumentException 예외 발생한다.")
    void  numberOutOfRangeThrowsException(){
        String input = "2147483648";
        assertThatThrownBy(() -> Operand.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_PARSE_ERROR.getMessage());
    }

    @Test
    @DisplayName("피연산자가 숫자가 아닌 다른 형태라면 IllegalArgumentException 예외 발생한다.")
    void numberParseThrowsException(){
        String input = "a";
        assertThatThrownBy(() -> Operand.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_PARSE_ERROR.getMessage());
    }

    @Test
    @DisplayName("피연산자가 음수라면 IllegalArgumentException 예외 발생한다.")
    void negativeNumberThrowsException(){
        String input = "-1";
        assertThatThrownBy(() -> Operand.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NOT_ALLOWED.getMessage());
    }


}
