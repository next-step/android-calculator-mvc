package com.lcw.study.nextstep.domain

import com.google.common.truth.Truth.assertThat
import com.lcw.study.nextstep.domain.OperationType.PLUS
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperationTypeTest {
    private var operation: OperationType = PLUS

    @CsvSource(
        "+,true",
        "-,true",
        "*,true",
        "/,true",
        "1,false",
        "@,false"
    )
    @ParameterizedTest(name = "{0}이 연산자면 true를 반환하고 아니면 false를 반환 한다}")
    internal fun test1(inputText: String, check: Boolean) {
        // given
        var text = inputText

        //when
        val actual = operation.checkTextIsOperationType(text)

        //then
        assertThat(actual).isEqualTo(check)
    }


    @Test
    @DisplayName("+이 입력되면 PLUS를 반환한다")

    internal fun test2() {
        // given
        var text = "+"
        //when
        val actual = operation.changeTextToOperation(text)

        //then
        assertThat(actual).isEqualTo(PLUS)
    }

    @CsvSource(
        "PLUS,1,2,3",
        "MINUS,3,2,1",
        "MULTIPLY,3,2,6",
        "DIVIDE,6,2,3",
    )
    @ParameterizedTest(name = "{0}일때 {1}과 {2}의 계산값은 {3}이다")
    internal fun test3(operation: OperationType, firstValue: Int, secondValue: Int,totalValue: Int) {
        // given

        //when
        val actual = operation.calculateOperation(operation,firstValue, secondValue)

        //then
        assertThat(actual).isEqualTo(totalValue)
    }
}