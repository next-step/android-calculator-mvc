package com.nextstep.domain

class Calculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) throw IllegalArgumentException(IS_NOT_OR_BLANK)
        return operandAndOperatorList(input)
    }

    private fun operandAndOperatorList(input: String): Int {
        val operandAndOperatorList = input.split(DELIMITER)
        val head = operandAndOperatorList.findFirstOperand()
        return operandAndOperatorList.drop(1).chunked(2).fold(head) { acc, element ->
            calculateTwoNumber(acc, element[0], element[1].toInt())
        }
    }

    private fun List<String>.findFirstOperand(): Int {
        val operandAndOperatorList = this
        if (operandAndOperatorList.first().isLetter() || operandAndOperatorList.last().isLetter()) {
            throw IllegalArgumentException(WRONG_INPUT)
        } else {
            return operandAndOperatorList[0].toInt()
        }
    }

    private fun calculateTwoNumber(num1: Int, operator: String, num2: Int): Int {
        return when (operator) {
            Operator.ADD.operator -> Operator.ADD.eval(num1, num2)
            Operator.SUBTRACT.operator -> Operator.SUBTRACT.eval(num1, num2)
            Operator.MULTIPLY.operator -> Operator.MULTIPLY.eval(num1, num2)
            Operator.DIVIDE.operator -> Operator.DIVIDE.eval(num1, num2)
            else -> throw IllegalArgumentException(IS_NOT_OPERATOR)
        }
    }

    private fun String.isLetter(): Boolean = this.toIntOrNull() == null

    companion object {
        const val DELIMITER = " "
        const val IS_NOT_OR_BLANK: String = "입력값이 null 이거나 공백 문자입니다."
        const val IS_NOT_OPERATOR: String = "사칙연산 기호가 아닙니다."
        const val WRONG_INPUT: String = "잘못된 입력입니다."
    }
}
