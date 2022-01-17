package jinsu.antilog.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class StringOperandTest {

    @Test
    fun givenStringTypeNumber_whenStringOperandToDouble_thenTypeIsDouble() {
        // given : 숫자 값 문자열이 주어지고
        val operand = "5"
        // when : StringOperand 를 Double 로 변환했을 때
        // then : Double 값이 나온다.
        assertThat(StringOperand(operand).toDouble())
            .isEqualTo(5.0)
    }

    @Test
    fun givenStringTypeNotNumber_whenChangeDouble_thenHappenException() {
        // given : 숫자가 아닌 문자열 값이 주어지고
        val operand = "5#"
        // when : StringOperand 를 Double 로 변환했을 때
        // then : IllegalArgumentException 이 발생한다.
        assertThrows(IllegalArgumentException::class.java){
            StringOperand(operand).toDouble()
        }.also {
            assertThat(it.message).isEqualTo("$operand 는 피연산자가 될 수 없습니다.")
        }
    }
}