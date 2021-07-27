package edu.nextstep.camp.domain.stringcalculator

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

/**
 * Created By Malibin
 * on 7월 22, 2021
 */

class OperatorTest {
    @Test
    fun `연산자 목록에 없는 문자가 들어오면 Exception`() {
        // given
        val weirdToken = "#"

        // then
        assertThrows(IllegalArgumentException::class.java) { Operator.find(weirdToken) }
            .also { assertThat(it).hasMessageThat().contains("$weirdToken 을 가진 연산자를 찾을 수 없습니다.") }
    }
}

@RunWith(Parameterized::class)
class OperatorFindParameterTest(
    private val operatorToken: String,
    private val expectedOperator: Operator,
) {
    companion object {
        @JvmStatic
        @Parameters(name = "{0} 토큰으로 {1} 연산자를 찾는다")
        fun tokenAndOperators(): Collection<Array<Any>> {
            return listOf(
                arrayOf("+", Operator.PLUS),
                arrayOf("-", Operator.MINUS),
                arrayOf("*", Operator.MULTIPLY),
                arrayOf("/", Operator.DIVIDE),
            )
        }
    }

    @Test
    fun `입력 문자에 맞는 연산자를 찾는다`() {
        // when
        val actualOperator = Operator.find(operatorToken)

        // then
        assertThat(actualOperator).isEqualTo(expectedOperator)
    }
}

@RunWith(Parameterized::class)
class OperatorCalculateParameterTest(
    private val operator: Operator,
    private val left: Operand,
    private val right: Operand,
    private val expectedResult: Operand,
) {
    companion object {
        @JvmStatic
        @Parameters(name = "{0} 연산자의 계산 전략 수행 테스트 : {1} {0} {2} = {3}")
        fun tokenAndOperators(): Collection<Array<Any>> {
            return listOf(
                arrayOf(Operator.PLUS, Operand(1), Operand(2), Operand(3)),
                arrayOf(Operator.MINUS, Operand(3), Operand(2), Operand(1)),
                arrayOf(Operator.MULTIPLY, Operand(2), Operand(5), Operand(10)),
                arrayOf(Operator.DIVIDE, Operand(10), Operand(2), Operand(5)),
            )
        }
    }

    @Test
    fun `각 연산자에 맞는 계산 전략에 맞게 계산을 수행한다`() {
        // when
        val actualResult = operator.calculate(left, right)

        // then
        assertThat(actualResult).isEqualTo(expectedResult)
    }
}
