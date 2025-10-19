package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자로 분리하여 숫자들의 합을 구한다.")
    void calculateSumWithDefaultDelimiter(){
        String input = "1:4,5:6";
        Calculator cal = Calculator.from(input);
        int result = cal.sum();
        assertThat(result).isEqualTo(16);
    }

    @Test
    @DisplayName("커스텀 구분자로 분리하여 숫자들의 합을 구한다.")
    void calculateSumWithCustomDelimiter(){
        String input = "///\\n1/2/3/4/5";
        Calculator cal = Calculator.from(input);
        int result = cal.sum();
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("빈 문자열은 그 합은 0이다")
    void calculateEmptyString(){
        String input = "";
        Calculator cal = Calculator.from(input);
        int result = cal.sum();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 사이가 비면 빈 자리는 0으로 계산된다.")
    void emptyBetweenDelimitersIsZero(){
        String input = "1::3";
        Calculator cal = Calculator.from(input);
        int result = cal.sum();
        assertThat(result).isEqualTo(4);
    }
}
