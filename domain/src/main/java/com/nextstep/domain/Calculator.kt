package com.nextstep.domain

class Calculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) throw IllegalArgumentException(IS_NOT_OR_BLANK)
        return calculateList(inputOperandOrOperator(input))
    }

    private fun inputOperandOrOperator(inputString: String): List<String> {
        val operandAndOperatorList = mutableListOf<String>()
        var mutableOperand = ""
        inputString.forEach { singleCharacter ->
            if (singleCharacter.isNumber()) {
                mutableOperand += singleCharacter
            } else if (singleCharacter.isLetter() && mutableOperand.isNotEmpty()) {
                val operator = singleCharacter.toString()
                operandAndOperatorList.add(mutableOperand)
                operandAndOperatorList.add(operator)
                mutableOperand = ""
            }
        }
        operandAndOperatorList.add(mutableOperand)
        return operandAndOperatorList
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
