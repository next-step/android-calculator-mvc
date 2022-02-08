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
            Operand(operand)
        }.exceptionOrNull()
        // then : IllegalArgumentException 이 발생한다.
        assertThat(actualException).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(actualException).hasMessageThat()
            .contains("$operand 는 피연산자가 될 수 없습니다.")
    }

    @Test
    fun `한 자리 피연산자 뒤에 피연산자를 추가하면 두 자리 피연산자가 된다`() {
        // given : 한자리 피연산자
        val operand = Operand("5")
        // when : 뒤에 피연산자를 추가하면
        val actualOperandValue = operand.addLastLetter(Operand("6"))
        // then :
        assertThat(actualOperandValue.toString()).isEqualTo("56")
    }

    @Test
    fun `두 자리 피연산자 뒷 자리를 제거하면 한 자리 피연산자가 된다`() {
        // given : 두 자리 피연산자
        val operand = Operand("56")
        // when : 뒷 자리를 제거하면
        val actualOperandValue = operand.removeLastLetter()
        // then :
        assertThat(actualOperandValue.toString()).isEqualTo("5")
    }

    @Test
    fun `한 자리 피연산자 뒷 자리를 제거하면 값 변화 없이 null 값이 나온다`() {
        // given : 두 자리 피연산자
        val operand = Operand("5")
        // when : 뒷 자리를 제거하면
        val actualResult = operand.removeLastLetter()
        val actualOperandValue = operand.toString()
        // then :
        assertThat(actualOperandValue).isEqualTo("5")
        assertThat(actualResult).isEqualTo(null)
    }
}