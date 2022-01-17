package jinsu.antilog.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {
    @Test
    fun givenExpression_whenCalculate_then10() {
        // given : "2 + 3 * 4 / 2" 수식이 주어지고
        val expressionString = "2 + 3 * 4 / 2"
        // when : 계산기로 계산을 했을 때
        val calculatedValue = Calculator().calculate(expressionString)
        // then : 10.0 이라는 결과가 나온다.
        assertThat(calculatedValue).isEqualTo(10.0)
    }

    @Test
    fun givenNullExpressionString_whenCalculate_thenThrowIllegalArgumentException() {
        // given : null 값의 수식이 주어지고
        val expressionString: String? = null
        // when : 계산기로 계산을 했을 때
        // then : IllegalArgumentException 이 발생한다.
        assertThrows(IllegalArgumentException::class.java){
            Calculator().calculate(expressionString)
        }.also {
            assertThat(it.message).isEqualTo("전달 받은 문자열이 Null 이거나 공백일 수 없습니다.")
        }
    }

    @Test
    fun givenBlankExpressionString_whenCalculate_thenThrowIllegalArgumentException() {
        // given : null 값의 수식이 주어지고
        val expressionString: String? = ""
        // when : 계산기로 계산을 했을 때
        // then : IllegalArgumentException 이 발생한다.
        assertThrows(IllegalArgumentException::class.java){
            Calculator().calculate(expressionString)
        }.also {
            assertThat(it.message).isEqualTo("전달 받은 문자열이 Null 이거나 공백일 수 없습니다.")
        }
    }

    @Test
    fun givenWrongExpressionString_whenCalculate_thenThrowIllegalArgumentException() {
        // given : 잘못된 수식이 주어지고
        val wrongExpressionString = "2 3"
        // when : 계산기로 계산을 했을 때
        // then : IllegalArgumentException 이 발생한다.
        assertThrows(IllegalArgumentException::class.java){
            Calculator().calculate(wrongExpressionString)
        }.also {
            assertThat(it.message).isEqualTo("입력받은 값은 수식이 아닙니다.")
        }
    }
}