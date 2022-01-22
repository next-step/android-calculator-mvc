package edu.nextstep.camp.calculator.domain

const val DELIMITER = " "

class Calculator {

    sealed class Result {

        data class Success(val value: String): Result()
        object Failure: Result()
    }

    private val expressionGenerator = ExpressionGenerator(DELIMITER)
    private val expressionParser = ExpressionParser(DELIMITER)

    var result: Result? = null
        private set

    fun insert(symbol: String) {
        expressionGenerator.append(symbol)
        result = Result.Success(expressionGenerator.generate())
    }

    fun delete() {
        expressionGenerator.delete()
        result = Result.Success(expressionGenerator.generate())
    }

    fun evaluate() {
        if (!expressionGenerator.isValid()) {
            result = Result.Failure
            return
        }

        val expression = expressionGenerator.generate()
        val evaluated = evaluate(expression)

        expressionGenerator.update(evaluated)
        result = Result.Success(evaluated)
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

