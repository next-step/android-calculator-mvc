package jinsu.antilog.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class OperandTest {

    @Test
    fun givenStringTypeNumber_whenStringOperandToDouble_thenTypeIsDouble() {
        // given : 숫자 값 문자열이 주어지고
        val operand = "5"
        // when : StringOperand 를 Double 로 변환했을 때
        val actualResult = Operand(operand).toDouble()
        // then : Double 값이 나온다.
        assertThat(actualResult)
            .isEqualTo(5.0)
    }

    @Test
    fun givenStringTypeNotNumber_whenChangeDouble_thenHappenException() {
        // given : 숫자가 아닌 문자열 값이 주어지고
        val operand = "5#"
        // when : StringOperand 를 Double 로 변환했을 때
        val actualException = kotlin.runCatching {
            Operand(operand).toDouble()
        }.exceptionOrNull()
        // then : IllegalArgumentException 이 발생한다.
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat()
            .contains("$operand 는 피연산자가 될 수 없습니다.")
    }
}