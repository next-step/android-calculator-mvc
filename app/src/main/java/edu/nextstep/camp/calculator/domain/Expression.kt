package edu.nextstep.camp.calculator.domain

import java.util.*

class Expression {
    private var onError: (() -> Unit)? = null
    private val separator = Separator()
    private val calculator = Calculator()
    private val value = Stack<String>()

    fun writeNumber(number: Number): String {
        value.push(number.value.toString())
        return getValue()
    }

    fun writeOperator(operator: Operator): String {
        when {
            value.isEmpty() -> return getValue()
            Operator.isOperator(value.peek()) -> {
                value.pop()
                value.push(operator.value)
            }
            else -> value.push(operator.value)
        }
        return getValue()
    }

    fun deleteExpression(): String {
        if (value.isNotEmpty()) {
            value.pop()
        }
        return getValue()
    }

    fun getValue(): String {
        return value.joinToString("")
    }

    fun calculate(): String {
        if(value.isNotEmpty()) {
            if(isLastExpressionIsOperator()) {
                value.pop()
                onError?.invoke()
            }
            val operators = separator.getOperators(getValue())
            val numbers = separator.getNumbers(getValue())
            checkValidateExpression(operators, numbers)

            val result = calculator.calculate(operators, numbers)
            value.clear()
            value.push(result.value.toString())
        }
        return getValue()
    }

    private fun isLastExpressionIsOperator(): Boolean {
        return if(value.isNotEmpty()) {
            val lastExpression = value.peek()
            return Operator.isOperator(lastExpression)
        } else {
            false
        }
    }

    private fun checkValidateExpression(operators: List<Operator>, numbers: List<Number>): Boolean {
        if (operators.size != numbers.size -1) throw RuntimeException("계산할 수 없는 식입니다.")
        return true
    }

    fun setOnError(onError: () -> Unit) {
        this.onError = onError
    }
}
