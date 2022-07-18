package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("문자열 계산기 테스트")
internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    companion object {
        @JvmStatic
        fun givenWrongOperationsTestSource() : Stream<Arguments> = Stream.of(
            Arguments.of(null, IllegalArgumentException("잘못된 요청입니다.")),
            Arguments.of(" ", IllegalArgumentException("잘못된 요청입니다.")),
            Arguments.of("121  % 222", IllegalArgumentException("잘못된 연산자가 포함되었습니다.")),
            Arguments.of("3 * 4 / ", IllegalArgumentException("완성되지 않은 수식입니다.")),
            Arguments.of("3 *//* 4", IllegalArgumentException("잘못된 연산자가 포함되었습니다.")),
        )

        fun evaluteOrException(calculator: Calculator, requested: String?) = try {
            calculator.evalute(requested)
        } catch (e: Exception) {
            e
        }

        fun assertThat(actual: Any, expected: Any?) {
            when {
                actual is Throwable && expected is Throwable -> {
                    assertThat(actual).isInstanceOf(expected::class.java)
                    assertThat(actual.message).startsWith(expected.message)
                }
                else -> assertThat(actual).isEqualTo(expected)
            }
        }
    }

    @Nested
    @DisplayName("올바른 연산이 주어지면")
    inner class GivenRightOperationsTest {
        @CsvSource(
            "'11 +    222', ${233.toDouble()}",
            "'11 -    222', ${(-211).toDouble()}",
            "'222 /    2 / 111', ${1.toDouble()}",
            "'222 *    2 * 3', ${1332.toDouble()}",
            "'2 + 3 * 4 / 2', ${10.toDouble()}"
        )
        @ParameterizedTest(name = "{0} = {1}")
        @DisplayName("계산은 성공해야 한다.")
        fun `연산을 한다`(requested: String?, expected: Double) {
            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }
    }

    @Nested
    @DisplayName("잘못된 연산이 주어지면")
    inner class GivenWrongOperationsTest {

        @MethodSource("edu.nextstep.camp.calculator.domain.CalculatorTest#givenWrongOperationsTestSource")
        @ParameterizedTest(name = "[{0}] -> {1}")
        @DisplayName("throw IllegalArgumentExcetion 해야 한다.")
        fun `잘못된 연산을 한다`(requested: String?, expected: IllegalArgumentException) {
            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }
    }
}