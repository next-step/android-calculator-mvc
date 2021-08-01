package edu.nextstep.camp.calculator.domain.operand

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NumberOperandTest {

    @Test
    fun `문자열을 더하면, 자리수가 늘어난다`() {
        // given
        val first = NumberOperand(13.0)
        val second = NumberOperand(4.0)
        // when
        val result = first.addNumberOperand(second)
        // then
        assertThat(result).isEqualTo(NumberOperand(134.0))
    }

    @Test
    fun `한자리 수를 지우면, Null이 된다`() {
        // given
        val operand = NumberOperand(8.0)
        // when
        val result = operand.deleteLast()
        // then
        assertThat(result).isNull()
    }

    @Test
    fun `두자리 수를 이상을 지우면, 맨 뒷자리가 지워진다`() {
        // given
        val operand = NumberOperand(823.0)
        // when
        val result = operand.deleteLast()
        // then
        assertThat(result).isEqualTo(NumberOperand(82.0))
    }
}
