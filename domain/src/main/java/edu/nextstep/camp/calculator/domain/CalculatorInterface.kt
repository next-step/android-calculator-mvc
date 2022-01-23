package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.calculator.Calculator
import edu.nextstep.camp.calculator.domain.exception.InvalidExpressionException
import edu.nextstep.camp.calculator.domain.expression.ExpressionGenerator
import edu.nextstep.camp.calculator.domain.expression.ExpressionParser

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
            calculator.evaluate(expression)
        }.onSuccess {
            Result.success(expressionGenerator.update(it).generate())
        }.onFailure {
            Result.failure<Throwable>(it)
        }
    }
}