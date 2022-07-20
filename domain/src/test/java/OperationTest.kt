package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import edu.nextstep.camp.calculator.domain.camp.calculator.Operation
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
            Arguments.of(Operation.Plus, 2, Operation.Plus.operator, 3, 5),
            Arguments.of(Operation.Minus, 2, Operation.Minus.operator, 3, (-1)),
            Arguments.of(Operation.Div, 6, Operation.Div.operator, 3, 2),
            Arguments.of(Operation.Mult, 2, Operation.Mult.operator, 3, 6),
        )
    }

    @Nested
    @DisplayName("연산자와 주어진 값에 대해")
    inner class ComputeTest {

        @MethodSource("edu.nextstep.camp.calculator.domain.OperationTest#getTestParameters")
        @DisplayName("연산이 성공해야 한다")
        @ParameterizedTest(name = "{1} {2} {3} = {4}")
        fun `연산`(operation: Operation, left: Double, operatorChar: Char, right: Double, expected: Double) {
            //when
            val actual = operation(left, right)

            //then
            assertThat(actual).isEqualTo(expected)
        }
    }
}