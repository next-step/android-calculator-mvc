package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.Operator.Companion.OPERATORS
import java.util.*

class Expression {
    private val value = Stack<String>()
    private val separator = Separator()

    fun writeNumber(number: String): String {
        value.push(number)
        return getValue()
    }

    fun writeOperator(operator: String): String {
        when {
            value.isEmpty() -> return getValue()
            OPERATORS.contains(value.peek()) -> {
                value.pop()
                value.push(operator)
            }
            else -> value.push(operator)
        }
        return getValue()
    }

    fun deleteExpression(): String {
        if (value.isNotEmpty()) {
            value.clear()
        }
        return getValue()
    }

    fun getValue(): String {
        return value.joinToString("")
    }

    fun calculate(): Number {
        if (value.isNotEmpty()) {
            var result = Number(0)
            val numbers = separator.getNumbers(getValue())
            val operators = separator.getOperators(getValue())

            val numberQueue: Queue<Number> = LinkedList<Number>()
            val operatorsQueue: Queue<Operator> = LinkedList<Operator>()

            numberQueue.addAll(numbers)
            operatorsQueue.addAll(operators)

            if (numberQueue.size > 1) {
                var leftNumber = numberQueue.poll()
                var rightNumber = numberQueue.poll()

                while (operatorsQueue.isNotEmpty()) {
                    val operator = operatorsQueue.poll().value
                    leftNumber = when (operator) {
                        Operator.PLUS -> leftNumber.plus(rightNumber)
                        Operator.MINUS -> leftNumber.minus(rightNumber)
                        Operator.MULTIPLY -> leftNumber.multiply(rightNumber)
                        Operator.DIVIDE -> leftNumber.divide(rightNumber)
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
            value.clear()
            value.push(result.value.toString())
            return result
        } else {
            return Number(0)
        }
    }
}
