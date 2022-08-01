import edu.nextstep.camp.calculator.domain.camp.calculator.Calculator
import exception.InvalidExpressionException
import expression.ExpressionGenerator
import expression.ExpressionParser

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

    fun evaluate() : Result<String> {
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