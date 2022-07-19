package edu.nextstep.camp.calculator.domain

/**
 * 계산식 관리 도구
 * Created by jeongjinhong on 2022. 07. 18..
 */
class Expression {
    var expression = ""
        private set

    fun initializeValue(value: Double) {
        expression = value.toString()
    }

    fun addOperator(operator: String): String {
        if (expression.isNotEmpty() && expression.last().isDigit()) {
            expression += " $operator"
        }
        return expression
    }

    fun addOperand(value: Int): String {
        if (expression.isNotEmpty() && !expression.last().isDigit()) {
            expression += " "
        }
        expression += value.toString()
        return expression
    }

    fun delete(): String {
        if (expression.isEmpty()) return expression
        // 앞의문자가 공백이거나 소수점이면 같이 지워버리기
        val deleteSize = if (prevCharIsBlankOrPoint()) INCLUDING_PREVIOUS else ONLY_CURRENT
        expression = expression.substring(0, expression.length - deleteSize)
        return expression
    }

    fun isCompletedExpression() = expression.last().isDigit()

    private fun prevCharIsBlankOrPoint() =
        expression.length > 1 && (expression[expression.lastIndex - 1] == ' ' || expression[expression.lastIndex - 1] == '.')

    companion object {
        private const val INCLUDING_PREVIOUS = 2
        private const val ONLY_CURRENT = 1
    }

}