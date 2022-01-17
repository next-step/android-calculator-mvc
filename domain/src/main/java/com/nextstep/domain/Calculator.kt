package com.nextstep.domain

class Calculator {
    private var operand = ""
    private val operandAndOperatorList = mutableListOf<String>()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) throw IllegalArgumentException(IS_NOT_OR_BLANK)
        setMoreThanTwoDigitList(input)
        return calculateList(operandAndOperatorList)
    }

    private fun setMoreThanTwoDigitList(inputString: String) {
        inputString.forEach(this::inputOperandAndOperator)
        operandAndOperatorList.add(operand)
    }

    private fun inputOperandAndOperator(singleCharacter: Char) {
        if (singleCharacter.isNumber()) {
            operand += singleCharacter
        } else if (singleCharacter.isLetter() && operand.isNotEmpty()) {
            val operator = singleCharacter.toString()
            operandAndOperatorList.add(operand)
            operandAndOperatorList.add(operator)
            operand = ""
        }
    }

    private fun calculateList(operandAndOperatorList: List<String>): Int {
        var result = 0
        var operator = "+"
        operandAndOperatorList.forEach { str ->
            if (str.isOperand()) {
                result = calculateTwoNumber(result, operator, str.toInt())
            } else if (str.isLetter()) {
                operator = str
            }
        }
        return result
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
    private fun String.isOperand(): Boolean = this.toIntOrNull() is Int
    private fun Char.isLetter(): Boolean = !this.isDigit() && !this.isWhitespace()
    private fun Char.isNumber(): Boolean = this.isDigit() && !this.isWhitespace()

    companion object {
        const val IS_NOT_OR_BLANK: String = "입력값이 null 이거나 공백 문자입니다."
        const val IS_NOT_OPERATOR: String = "사칙연산 기호가 아닙니다."
    }
}
