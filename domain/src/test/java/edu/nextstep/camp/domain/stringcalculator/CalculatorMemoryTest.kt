package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created By Malibin
 * on 7월 29, 2021
 */

class CalculatorMemoryTest {

    @Test
    fun 입력된_숫자가_없을_때_숫자를_넣으면_해당_숫자가_눌린_수식을_리턴한다() {
        // given
        val calculatorMemory = CalculatorMemory()

        // when
        val expression: String = calculatorMemory.putOperand(Operand(3))

        // then
        assertThat(expression).isEqualTo("3")
    }

    @Test
    fun 입력된_숫자가_있을_때_숫자를_넣으면_기존_숫자와_합쳐진_숫자_수식을_리턴한다(){
        // given
        val calculatorMemory = CalculatorMemory()
        calculatorMemory.putOperand(Operand(3))

        // when
        val expression: String = calculatorMemory.putOperand(Operand(4))

        // then
        assertThat(expression).isEqualTo("34")
    }
}
