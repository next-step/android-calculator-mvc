package jinsu.antilog.domain

import com.google.common.truth.Truth.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

class ExpressionBufferTest {
    @Test
    fun `빈 수식에 피연산자를 추가하면 피연산자가 추가된 수식이 나온다`() {
        // given : 빈 수식에
        val expressionBuffer = ExpressionBuffer()
        // when : 피연산자를 추가하면
        val operand = Operand("5")
        val actualExpression = expressionBuffer.addOperand(operand)
        // then : 피연산자가 추가된 수식이 나온다.
        assertThat(actualExpression).isEqualTo("5")
    }

    @Test
    fun `피연산자와 연산자가 있는 수식에 피연산자를 추가하면 피연산자가 추가된 수식이 나온다`() {
        // given : "5 + " 라는 수식에
        val expressionBuffer = ExpressionBuffer().apply {
            addOperand(Operand("5"))
            addOperator(Operator.findOperatorBySymbol("+"))
        }
        // when : 피연산자를 추가하면
        val operand = Operand("1")
        val actualExpression = expressionBuffer.addOperand(operand)
        // then : 피연산자가 추가된 수식이 나온다.
        assertThat(actualExpression).isEqualTo("5 + 1")
    }

    @Test
    fun `입력된 피연산자가 있을 때 피연산자를 추가하면 기존 피연산자 뒤에 해당 피연산자가 추가된다`() {
        // given : 입력된 피연산자가 있을 때
        val expressionBuffer = ExpressionBuffer().apply {
            addOperand(Operand("8"))
        }
        // when : 피연산자를 추가하면
        val operand = Operand("9")
        val actualExpression = expressionBuffer.addOperand(operand)
        // then : 기존 피연산자 뒤에 해당 피연산자가 추가된다.
        assertThat(actualExpression).isEqualTo("89")
    }

    @Test
    fun `빈 수식에 연산자를 추가하면 아무런 변화가 없다`() {
        // given :
        val expressionBuffer = ExpressionBuffer()
        // when :
        val operator = Operator.findOperatorBySymbol("-")
        val actualExpression = expressionBuffer.addOperator(operator)
        // then :
        assertThat(actualExpression).isEmpty()
    }

    @Test
    fun `입력된 피연산자가 있을 때 연산자를 추가하면 연산자가 추가된 수식이 나온다`() {
        // given :
        val expression = ExpressionBuffer().apply {
            addOperand(Operand("1"))
        }
        // when :
        val operator = Operator.findOperatorBySymbol("÷")
        val actualExpression = expression.addOperator(operator)
        // then :
        assertThat(actualExpression).isEqualTo("1 ÷")
    }

    @Test
    fun `입력된 피연산자와 연산자가 있을 때 연산자를 추가하면 추가된 연산자로 변경된 수식이 나온다`() {
        // given :
        val expression = ExpressionBuffer().apply {
            addOperand(Operand("1"))
            addOperator(Operator.findOperatorBySymbol("×"))
        }
        // when :
        val operator = Operator.findOperatorBySymbol("÷")
        val actualExpression = expression.addOperator(operator)
        // then :
        assertThat(actualExpression).isEqualTo("1 ÷")
    }

    @Test
    fun `빈 수식의 맨뒤를 지우면 아무련 변화가 없다`() {
        // given :
        val expressionBuffer = ExpressionBuffer()
        // when :
        val actualExpression = expressionBuffer.removeLast()
        // then :
        assertThat(actualExpression).isEmpty()
    }

    @Test
    fun `입력된 수식이 있을 때 수식을 반환하면 현재 저장된 수식을 반환한다`() {
        // given :
        val expressionBuffer = ExpressionBuffer().apply {
            addOperand(Operand("32"))
            addOperator(Operator.findOperatorBySymbol("+"))
            addOperand(Operand("1"))
        }
        // when :
        val actualExpression = expressionBuffer.getStringExpression()
        // then :
        assertThat(actualExpression).isEqualTo("32 + 1")
    }
}

@RunWith(Parameterized::class)
class ExpressionRemoveTest(
    private val expression: ExpressionBuffer,
    private val expectedExpression: String
) {
    @Test
    fun `수식에서 지우기를 하면 수식의 맨 뒤에 한자리만 지워진다`() {
        // when :
        val actualExpression = expression.removeLast()
        // then :
        assertThat(actualExpression).isEqualTo(expectedExpression)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "수식이 {0} 이고 기대 결과가 {1} 일 때")
        fun removeExpressionTestList() = listOf(
            arrayOf(
                ExpressionBuffer().apply {
                    addOperand(Operand("32"))
                    addOperator(Operator.findOperatorBySymbol("+"))
                    addOperand(Operand("1"))
                },
                "32 +"
            ),
            arrayOf(
                ExpressionBuffer().apply {
                    addOperand(Operand("32"))
                    addOperator(Operator.findOperatorBySymbol("+"))
                },
                "32"
            ),
            arrayOf(
                ExpressionBuffer().apply {
                    addOperand(Operand("32"))
                },
                "3"
            ),
        )
    }
}