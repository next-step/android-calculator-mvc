package edu.nextstep.camp.domain

import edu.nextstep.camp.domain.calculator.Calculator
import edu.nextstep.camp.domain.exception.InvalidExpressionException
import edu.nextstep.camp.domain.expression.Expression
import edu.nextstep.camp.domain.expression.ExpressionProcessor

private const val DELIMITER = " "

class CalculatorInterface {
    private val expression = Expression(DELIMITER)
    private val expressionProcessor = ExpressionProcessor(DELIMITER)
    private val calculator = Calculator(expressionProcessor)

    fun insert(symbol: String) = Result.success(
        expression.append(symbol).generate()
    )

    fun delete() = Result.success(
        expression.delete().generate()
    )

    fun evaluate(): Result<String> {
        if (!expression.isValid()) {
            return Result.failure(InvalidExpressionException())
        }

        return runCatching {
            val expression = expression.generate()
            val result = calculator.evaluate(expression)

            this.expression.update(result).generate()
        }
    }
}