package edu.nextstep.camp.calculator.domain

import java.util.*

class Expression private constructor(val value: String) {
    private val separator = Separator()

    init {
        checkBlankExpression(value)
    }

    private fun checkBlankExpression(value: String) {
        if (value.isBlank()) throw IllegalArgumentException("수식은 공백일 수 없습니다.")
    }

    fun calculate(): Number {
        var result = Number(0)
        val numbers = separator.getNumbers(value)
        val operators = separator.getOperators(value)

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

        return result
    }

    companion object {
        fun create(value: String): Expression {
            return Expression(removeSpace(value))
        }

        private fun removeSpace(string: String): String {
            return string.replace(" ", "")
        }
    }
}
