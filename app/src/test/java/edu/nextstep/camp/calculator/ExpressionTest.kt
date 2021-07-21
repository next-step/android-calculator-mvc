package edu.nextstep.camp.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class ExpressionTest {

    @Test(expected = IllegalArgumentException::class)
    fun `수식이 공백일 경우 Exception이 발생한다`() {
        val blankExpression = ""
        Expression.create(blankExpression)
    }

    @Test
    fun `수식에서 숫자들만 분리한다`() {
        //given
        val expression = Expression.create("1 + 3 - 4")

        //when
        val numbers = expression.getNumbers()

        //then
        assertThat(numbers).isEqualTo(listOf(Number(1), Number(3), Number(4)))
    }

    @Test
    fun `수식에서 기호들을 분리해준다`() {
        //given
        val expression = Expression.create("1 + 3 - 4")

        //when
        val operators = expression.getOperators()

        //then
        assertThat(operators).isEqualTo(listOf("+", "-"))
    }

    @Test
    fun `수식에 공백이 존재한다면 모두 제거해준다`() {
        //given
        val string = "1 + 3 + 4 "

        //when
        val expression = Expression.create(string)

        //then
        assertThat(expression._value).isEqualTo("1+3+4")
    }

    @Test
    fun `수식이 주어지면 해당 수식을 순서대로 계산한다`() {
        var result = Number(0)
        val expression = Expression.create("1 + 3 × 5")

        val numbers = expression.getNumbers()
        val symbols = expression.getOperators()

        val numberQueue: Queue<Number> = LinkedList<Number>()
        val symbolQueue: Queue<String> = LinkedList<String>()

        numberQueue.addAll(numbers)
        symbolQueue.addAll(symbols)

        if (numberQueue.size > 1) {
            var leftNumber = numberQueue.poll()
            var rightNumber = numberQueue.poll()

            while (symbolQueue.isNotEmpty()) {
                leftNumber = when (symbolQueue.poll()) {
                    "+" -> leftNumber.plus(rightNumber)
                    "-" -> leftNumber.minus(rightNumber)
                    "×" -> leftNumber.multiply(rightNumber)
                    "÷" -> leftNumber.divide(rightNumber)
                    else -> throw IllegalArgumentException("올바른 수식이 아닙니다.")
                }

                if (numberQueue.isNotEmpty()) {
                    rightNumber = numberQueue.poll()
                } else {
                    result = leftNumber
                }
            }
        } else {
            result = numberQueue.poll()
        }

        assertThat(result).isEqualTo(Number(20))
    }
}
