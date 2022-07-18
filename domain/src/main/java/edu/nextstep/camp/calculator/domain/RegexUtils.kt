package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.model.Operator

object RegexUtils {
    private const val NUMBER_REGEX = "\\d+"
    private const val ONE_DIGIT_NUMBER_REGEX = "\\d"

    fun getOperatorsList(expression: String) =
        getRegexForOperators().findAll(expression).map { it.value }.toList()

    fun getOperandsList(expression: String) =
        NUMBER_REGEX.toRegex().findAll(expression).map { Integer.parseInt(it.value) }.toList()

    fun checkExpressionIsValid(expression: String) =
        getRegexForValidExpression().matches(expression)

    fun checkExpressionIsOneDigitNumber(expression: String) =
        ONE_DIGIT_NUMBER_REGEX.toRegex().matches(expression)

    private fun getRegexForOperators() = Operator.values()
        .filter { it.value != null }
        .map { it.value }
        .joinToString(separator = "|\\", prefix = "[\\", postfix = "]")
        .toRegex()

    private fun  getRegexForValidExpression() = "(((\\d+)(${getRegexForOperators().pattern}))*)(\\d+)".toRegex()
}
