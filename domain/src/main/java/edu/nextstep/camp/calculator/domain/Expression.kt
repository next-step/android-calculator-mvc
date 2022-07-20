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
        val deleteSize = getDeleteSizeDependingOnExistenceOfSpacesOrDecimal()
        expression = expression.substring(0, expression.length - deleteSize)
        return expression
    }

    private fun getDeleteSizeDependingOnExistenceOfSpacesOrDecimal(): Int {
        val hasPrevChar = expression.length > 1
        if (!hasPrevChar) return ONLY_CURRENT

        val isPrevCharBlank = expression[expression.lastIndex - 1] == ' '
        val isPrevCharDecimal = expression[expression.lastIndex - 1] == '.'
        return if (isPrevCharBlank || isPrevCharDecimal) INCLUDING_PREVIOUS else ONLY_CURRENT
    }

    fun isCompletedExpression() = expression.isNotEmpty() && expression.last().isDigit()

    companion object {
        private const val INCLUDING_PREVIOUS = 2
        private const val ONLY_CURRENT = 1
    }

}