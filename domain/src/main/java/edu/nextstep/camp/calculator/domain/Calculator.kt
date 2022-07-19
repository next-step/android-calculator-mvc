package edu.nextstep.camp.calculator.domain

import java.util.*

class Calculator(private val delimiter: Char) {
    private val expressionStack = Stack<String>()
    val expression: String
        get() = expressionStack.joinToString(delimiter.toString())

    fun addOperand(number: String) {
        if (expressionStack.isNotEmpty() && expressionStack.last().toIntOrNull() != null) {
            expressionStack.push(expressionStack.pop() + number)
        } else {
            expressionStack.push(number)
        }
    }

    fun addOperator(operator: String) {
        if (expressionStack.isEmpty()) return
        if (expressionStack.last().toIntOrNull() == null) {
            expressionStack.pop()
        }
        expressionStack.push(operator)
    }

    fun delete() {
        if (expressionStack.isEmpty()) return
        val value = expressionStack.pop()
        if (value.toIntOrNull() == null) return
        if (value.toInt() >= SMALLEST_OF_TWO_DIGITS) {
            expressionStack.push(value.dropLast(1))
        }
    }


    fun evaluate(onError: (() -> Unit)? = null) {
        if (expressionStack.isEmpty() || expressionStack.last().toIntOrNull() == null) {
            onError?.invoke()
            return
        }

        val expression = expressionStack.joinToString(delimiter.toString())
        require(expression.isNotBlank()) { IllegalArgumentException(IS_NULL_OR_BLANK) }

        val inputList = Splitter.splitByDelimiter(expression, delimiter)
        require(inputList.size % EVEN_COMPARISON_NUMBER == RESULT_WHEN_ODD_NUMBER) {
            IllegalArgumentException(NOT_MATCH_OPERATORS_AND_OPERANDS)
        }

        // 첫숫자는 바로 계산하기 위해 저장한다.
        var output = Operand.of(inputList.first())
        for (index in NUMBER_OF_EXCLUDING_THE_FIRST_INDEX until inputList.size step SIZE_OF_CALCULATION_UNIT) {
            output =
                Operator.of(inputList[index])
                    .calculate(output, Operand.of(inputList[index + INDEX_OF_NUMBER]))
        }

        expressionStack.clear()
        expressionStack.push(output.value.toString())
    }


    companion object {
        private const val EVEN_COMPARISON_NUMBER = 2
        private const val RESULT_WHEN_ODD_NUMBER = 1

        private const val NUMBER_OF_EXCLUDING_THE_FIRST_INDEX = 1
        private const val SIZE_OF_CALCULATION_UNIT = 2

        private const val SMALLEST_OF_TWO_DIGITS = 10

        private const val INDEX_OF_NUMBER = 1

        private const val IS_NULL_OR_BLANK = "인풋이 null이거나 blank입니다."
        private const val NOT_MATCH_OPERATORS_AND_OPERANDS = "연산자와 피연산자 갯수가 맞지 않습니다."
    }
}