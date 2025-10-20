package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자로 분리하여 숫자들의 합을 구한다.")
    void calculateSumWithDefaultDelimiter(){
        String input = "1:4,5:6";
        Calculator cal =
        int result = cal.sum();
        assertThat(result).isEqualTo(16);
    }
}
