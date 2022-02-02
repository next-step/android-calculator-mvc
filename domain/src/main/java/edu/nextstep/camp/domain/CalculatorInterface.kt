package edu.nextstep.camp.domain

import edu.nextstep.camp.domain.calculator.Calculator
import edu.nextstep.camp.domain.exception.InvalidExpressionException
import edu.nextstep.camp.domain.expression.ExpressionGenerator
import edu.nextstep.camp.domain.expression.ExpressionParser

private const val DELIMITER = " "

class CalculatorInterface {
    private val expressionGenerator = ExpressionGenerator(DELIMITER)
    private val expressionParser = ExpressionParser(DELIMITER)
    private val calculator = Calculator(expressionParser)

    fun insert(symbol: String) = Result.success(
        expressionGenerator.append(symbol).generate()
    )

    fun delete() = Result.success(
        expressionGenerator.delete().generate()
    )

    fun evaluate(): Result<String> {
        if (!expressionGenerator.isValid()) {
            return Result.failure(InvalidExpressionException())
        }

        return runCatching {
            val expression = expressionGenerator.generate()
            val result = calculator.evaluate(expression)

            expressionGenerator.update(result).generate()
        }
    }
}