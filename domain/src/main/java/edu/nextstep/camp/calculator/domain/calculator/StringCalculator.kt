package edu.nextstep.camp.calculator.domain.calculator

import edu.nextstep.camp.calculator.domain.expression.Expression

class StringCalculator {
    companion object {
        private const val ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY = "입력 받은 파라메터가 NULL 또는 빈 값입니다."
        private const val ERROR_MESSAGE_ARGUMENT_INVALID_FORMULA_FORMAT = "입력 받은 파라메터가 올바른 형식의 수식이 아닙니다."

        private const val FORMULA_SPLIT_DELIMITER = " "
    }

    fun calculate(expression: Expression): Expression {
        val calculatedValue = calculate("$expression").toInt()
        return Expression().apply {
            insertOperand("$calculatedValue")
        }
    }

    fun calculate(formula: String): Double {
        validateNullOrEmpty(formula)
        val splitFormulas = formula.trim().split(FORMULA_SPLIT_DELIMITER)
        validateFormulaFormat(splitFormulas)

        var result = 0.0
        for(i:Int in 1 until splitFormulas.size step(2)) {
            val leftNum = Operand(
                if (i == 1) { splitFormulas[i - 1].toDouble() } else { result }
            )
            val rightNum = Operand(splitFormulas[i+1].toDouble())
            result = Operator.fromSymbol(splitFormulas[i])
                .calculate(leftNum, rightNum)
        }
        return result
    }

    private fun validateNullOrEmpty(formula: String) {
        if(formula.isEmpty()) {
            throw IllegalArgumentException(ERROR_MESSAGE_ARGUMENT_NULL_OR_EMPTY)
        }
    }

    private fun validateFormulaFormat(splitFormulas: List<String>) {
        if(splitFormulas.size < 3 || splitFormulas.size % 2 == 0) {
            throw IllegalArgumentException(ERROR_MESSAGE_ARGUMENT_INVALID_FORMULA_FORMAT)
        }
    }
}