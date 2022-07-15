package edu.nextstep.camp.calculator.domain

object RegexUtils {
    private const val NUMBER_REGEX = "\\d+"
    private const val NON_NUMBER_REGEX = "[-+×÷]"
    private const val VALID_EXPRESSION_REGEX = "(((\\d+)([-+×÷]))*)(\\d+)"


    fun getOperatorsList(expression: String) =
        NON_NUMBER_REGEX.toRegex().findAll(expression).map { it.value }.toList()

    fun getOperandsList(expression: String) =
        NUMBER_REGEX.toRegex().findAll(expression).map { Integer.parseInt(it.value) }.toList()

    fun checkExpressionIsValid(expression: String) =
        VALID_EXPRESSION_REGEX.toRegex().matches(expression)
}
