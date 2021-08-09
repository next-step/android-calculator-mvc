package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created By Malibin
 * on 7월 29, 2021
 */

class CalculatorMemoryTest {

    @Test
    fun 생성자에_피연산자를_연속으로_넣어도_수식의_숫자는_서로_붙어있다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(3),
            Operand(4),
            Operand(5),
            Operator.PLUS,
            Operand(6),
            Operand(7),
        )

        // when
        val expression: String = calculatorMemory.getExpression()

        // then
        assertThat(expression).isEqualTo("345 + 67")
    }

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
    fun 입력된_숫자가_있을_때_숫자를_넣으면_기존_숫자와_합쳐진_숫자_수식을_리턴한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(3)
        )

        // when
        val expression: String = calculatorMemory.putOperand(Operand(4))

        // then
        assertThat(expression).isEqualTo("34")
    }

    @Test
    fun 입력된_숫자가_있을_때_연산자를_넣으면_합쳐진_수식을_리턴한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(3)
        )

        // when
        val expression: String = calculatorMemory.putOperator(Operator.MINUS)

        // then
        assertThat(expression).isEqualTo("3 -")
    }

    @Test
    fun 숫자_연산자_순으로_입력되어_있을_때_숫자를_넣으면_해당_숫자가_추가된_수식을_리턴한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(3),
            Operator.PLUS
        )

        // when
        val expression = calculatorMemory.putOperand(Operand(5))

        // then
        assertThat(expression).isEqualTo("3 + 5")
    }

    @Test
    fun 숫자_연산자_순으로_입력되어_있을_때_연산자를_넣으면_입력되어있던_연산자가_새롭게_입력한_연산자로_변경된다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(3),
            Operator.MINUS,
        )

        // when
        val expression = calculatorMemory.putOperator(Operator.DIVIDE)

        // then
        assertThat(expression).isEqualTo("3 ÷")
    }

    @Test
    fun 메모리가_비어있을_때_연산자를_클릭하면_빈_문자열을_반환한다() {
        // given
        val calculatorMemory = CalculatorMemory()

        // when
        val expression = calculatorMemory.putOperator(Operator.MULTIPLY)

        // then
        assertThat(expression).isEqualTo("")
    }

    @Test
    fun 메모리가_비어있을_때_최근_입력을_지우면_빈_문자열을_반환한다() {
        // given
        val calculatorMemory = CalculatorMemory()

        // when
        val expression: String = calculatorMemory.removeLast()

        // then
        assertThat(expression).isEqualTo("")
    }

    @Test
    fun 숫자_연산자_순으로_입력되어_있을_때_최근_입력을_지우면_숫자_문자열을_반환한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(73),
            Operator.MULTIPLY
        )

        // when
        val expression: String = calculatorMemory.removeLast()

        // then
        assertThat(expression).isEqualTo("73")
    }


    @Test
    fun 여러_자리의_피연산자가_입력되어_있을_때_최근_입력을_지우면_끝_자리가_빠진_숫자_문자열을_반환한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(7),
            Operand(3),
            Operand(5),
            Operand(1),
        )

        // when
        val expression: String = calculatorMemory.removeLast()

        // then
        assertThat(expression).isEqualTo("735")
    }

    @Test
    fun 한_자리_피연산자가_입력되어_있을_때_최근_입력을_지우면_피연산자가_삭제된_문자열을_반환한다() {
        // given
        val calculatorMemory = CalculatorMemory(
            Operand(7),
            Operator.DIVIDE,
            Operand(1),
        )

        // when
        val expression: String = calculatorMemory.removeLast()

        // then
        assertThat(expression).isEqualTo("7 ÷")
    }
}
