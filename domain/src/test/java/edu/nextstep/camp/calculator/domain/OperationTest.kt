package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("연산자 기능 테스트")
class OperationTest {
    companion object {
        @JvmStatic
        fun getTestParameters(): Stream<Arguments> = Stream.of(
            Arguments.of(Operation.Plus, 2, 3, 5),
            Arguments.of(Operation.Minus, 2, 3, (-1)),
            Arguments.of(Operation.Div, 6, 3, 2),
            Arguments.of(Operation.Mult, 2, 3, 6),
        )
    }

    @Nested
    @DisplayName("연산자와 주어진 값에 대해")
    inner class ComputeTest {

        @MethodSource("edu.nextstep.camp.calculator.domain.OperationTest#getTestParameters")
        @DisplayName("연산이 성공해야 한다")
        @ParameterizedTest(name = "입력값: {1}, {2}, 결과: {3}, 연산자: {0}")
        fun `연산`(operation: Operation, left: Double, right: Double, expected: Double) {
            //when
            val actual = operation(left, right)

            //then
            assertThat(actual).isEqualTo(expected)
        }
    }
}