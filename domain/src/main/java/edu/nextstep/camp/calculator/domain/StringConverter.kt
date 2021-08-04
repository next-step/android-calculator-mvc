package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.operand.Operator

class StringConverter(private val operators: Array<String>) {
    private var regex: Regex = getExpressionRegex()

    fun convert(expression: String): Pair<List<Double>, List<Operator>> {
        validateExpression(expression = expression.trim())
        return getOperands(expression) to getOperators(expression)
    }

    private fun getOperands(expression: String) =
        expression.split(*operators).map(String::toDouble)

    private fun getOperators(expression: String) =
        expression.map(Char::toString)
            .filter { operators.contains(it) }
            .map { Operator.getOperator(it) }

    private fun getExpressionRegex(): Regex {
        val operatorsString = operators.joinToString("").replace("-", "\\-")
        val pattern = "\\d+([$operatorsString]\\d+)+"
        return Regex(pattern)
    }

    private fun validateExpression(expression: String) {
        if (regex.matches(expression).not()) {
            throw IllegalArgumentException("Wrong Expression Input")
        }
    }
}
