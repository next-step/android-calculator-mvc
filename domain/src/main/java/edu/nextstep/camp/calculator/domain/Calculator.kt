package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.exception.InvalidExpressionException

const val DELIMITER = " "

class Calculator {

    private val expressionGenerator = ExpressionGenerator(DELIMITER)
    private val expressionParser = ExpressionParser(DELIMITER)

    var result: Result<String>? = null
        private set

    fun insert(symbol: String) {
        expressionGenerator.append(symbol)
        result = Result.success(expressionGenerator.generate())
    }

    fun delete() {
        expressionGenerator.delete()
        result = Result.success(expressionGenerator.generate())
    }

    fun evaluate() {
        if (!expressionGenerator.isValid()) {
            result = Result.failure(InvalidExpressionException())
            return
        }

        val expression = expressionGenerator.generate()
        val evaluated = evaluate(expression)

        expressionGenerator.update(evaluated)
        result = Result.success(evaluated)
    }

    fun evaluate(expression: String?): String {
        val chunks = expressionParser.parse(expression)
        val firstDigit = chunks.first().toInt()
        val remainChunks = chunks.drop(1)

        return remainChunks.chunked(2)
            .fold(firstDigit) { acc, (token, digit) -> BinaryCalculator.of(token).evaluate(acc, digit.toInt()) }
            .toString()
    }
}

