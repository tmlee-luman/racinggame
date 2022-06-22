package com.lumanlab.racinggame.domain.value;

import com.lumanlab.racinggame.exception.EmptyAndNullSourceException;
import com.lumanlab.racinggame.exception.NumericException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @DisplayName("자동차 이름에 입력된 값이 공백일 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {",,", ",,,"})
    void validateEmptyFromCarNames(String input) {
        List<String> strings = convertList(input);
        System.out.println("사이즈-->" + strings.size());
        for (String string : strings) {
            System.out.println("공백이냐 -->" + string);
        }
        assertThatThrownBy(() -> Names.createNames(convertList(input)))
                .isInstanceOf(EmptyAndNullSourceException.class);
    }

    @DisplayName("자동차 이름에 입력된 값이 숫자일 경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"3", "54", "2", "52"})
    void validateNumericFromCarNames(String input) {
        assertThatThrownBy(() -> Names.createNames(convertList(input)))
                .isInstanceOf(NumericException.class);
    }

    private List<String> convertList(String input) {
        return Arrays.asList(input.split(","));
    }
}