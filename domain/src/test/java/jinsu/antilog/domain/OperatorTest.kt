package jinsu.antilog.domain

import com.google.common.truth.Truth.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.lang.IllegalArgumentException

class OperatorTest {
    @Test
    fun givenNotOperatorSymbol_whenFindOperator_thenWrongOperator() {
        // given : 연산자 기호가 아닌 기호가 주어지고
        val notOperateSymbol = "@"
        // when : 연산자를 찾을때
        // then : IllegalArgumentException 발생
        assertThrows(IllegalArgumentException::class.java){
            Operator.findOperatorBySymbol(notOperateSymbol)
        }.also {
            assertThat(it.message).isEqualTo(
                "$notOperateSymbol 을 연산자로 사용할 수 없습니다."
            )
        }
    }
}

@RunWith(Parameterized::class)
class ParameterizedOperatorTest(
    private val symbol: String,
    private val operateValue: Int,
    private val operator : Operator
) {
    @Test
    fun givenOperatorSymbol_whenFindOperator_thenCorrectOperator() {
        // given : 연산자 기호가 주어지고
        // when : Operator 에서 기호를 찾았을 때
        val foundOperator = Operator.findOperatorBySymbol(symbol)
        // then : 연산자와 일치하는 Operator 가 주어진다.
        assertThat(foundOperator).isEqualTo(operator)
    }

    @Test
    fun givenOperand_whenCalculate_thenSuccessfulResult() {
        // given : 피연산자가 주어지고
        val left = 10.0
        val right = 5.0
        // when : 연산을 실행했을때
        val operateResult = operator.operate(left, right)
        // then : 연산 결과가 정상적으로 나온다.
        assertThat(operateResult).isEqualTo(operateValue)
    }


    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun operateTestList() = listOf(
            arrayOf("+", 15, Operator.Plus),
            arrayOf("-", 5, Operator.Minus),
            arrayOf("*", 50, Operator.Multiply),
            arrayOf("/", 2, Operator.Divide)
        )
    }
}

@RunWith(Parameterized::class)
class ParameterizedSubSymbolOperatorTest(
    private val subSymbol: String,
    private val operateValue: Int,
    private val operator : Operator
) {
    @Test
    fun givenOperatorSymbol_whenFindOperator_thenCorrectOperator() {
        // given : 연산자 기호가 주어지고
        // when : Operator 에서 기호를 찾았을 때
        val foundOperator = Operator.findOperatorBySymbol(subSymbol)
        // then : 연산자와 일치하는 Operator 가 주어진다.
        assertThat(foundOperator).isEqualTo(operator)
    }

    @Test
    fun givenOperand_whenCalculate_thenSuccessfulResult() {
        // given : 피연산자가 주어지고
        val left = 10.0
        val right = 5.0
        // when : 연산을 실행했을때
        val operateResult = operator.operate(left, right)
        // then : 연산 결과가 정상적으로 나온다.
        assertThat(operateResult).isEqualTo(operateValue)
    }




    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun operateTestList() = listOf(
            arrayOf("×", 50, Operator.Multiply),
            arrayOf("÷", 2, Operator.Divide)
        )
    }
}

@RunWith(Parameterized::class)
class OperatorSubSymbolTest(
    private val expectedRawStringSubSymbol: String?,
    private val operator: Operator
) {
    @Test
    fun `연산자가 있을때 해당 연산자의 subSymbol 이 일치하는지 확인`() {
        val actualSubSymbol = operator.subSymbol
        assertThat(actualSubSymbol).isEqualTo(expectedRawStringSubSymbol)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun operatorSubSymbolTest() = listOf(
            arrayOf(null, Operator.Plus),
            arrayOf(null, Operator.Minus),
            arrayOf("*", Operator.Multiply),
            arrayOf("/", Operator.Divide)
        )
    }

}

