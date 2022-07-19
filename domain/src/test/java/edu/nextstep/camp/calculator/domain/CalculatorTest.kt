package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
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
        fun givenRightOperationsTestSource() : Stream<Arguments> = Stream.of(
            Arguments.of("11 +    222", 233.toDouble()),
            Arguments.of("11 -    222", (-211).toDouble()),
            Arguments.of("222 /    2 / 111", 1.toDouble()),
            Arguments.of("222 *    2 * 3", 1332.toDouble()),
            Arguments.of("2 + 3 * 4 / 2", 10.toDouble()),
            Arguments.of("-1 + 2", 1.toDouble()),
            Arguments.of("3 / 2 - 2 * 2", (-1).toDouble()),
            Arguments.of("-1.5 + 2", 0.5),
        )
    }

    @Nested
    @DisplayName("올바른 연산이 주어지면")
    inner class GivenRightOperationsTest {

        @MethodSource("edu.nextstep.camp.calculator.domain.CalculatorTest#givenRightOperationsTestSource")
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

        @Test
        fun `입력값이 null일 경우 IllegalArgumentException throw`() {
            //given
            val requested = null
            val expected = IllegalArgumentException("잘못된 요청입니다.")

            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }

        @Test
        fun `입력값이 공백 일 경우 IllegalArgumentException throw`() {
            //given
            val requested = " "
            val expected = IllegalArgumentException("잘못된 요청입니다.")

            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }

        @Test
        fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
            //given
            val requested = "121  % 222"
            val expected = IllegalArgumentException("잘못된 연산자가 포함되었습니다.")

            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }

        @Test
        fun `완성되지 않는 수식 요청의 경우 IllegaArgumentException throw`() {
            //given
            val requested = "3 * 4 / "
            val expected = IllegalArgumentException("완성되지 않은 수식입니다.")

            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }

        @Test
        fun `연산자가 연속적으로 입력되었을 경우 IllegalArgumentException throw`() {
            //given
            val requested = "3 *//* 4"
            val expected = IllegalArgumentException("잘못된 연산자가 포함되었습니다.")

            //when
            val actual = evaluteOrException(calculator, requested)

            //then
            assertThat(actual, expected)
        }
    }

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