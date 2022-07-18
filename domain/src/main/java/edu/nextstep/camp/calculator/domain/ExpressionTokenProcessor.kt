package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.exception.ExpressionNotCompleteException
import edu.nextstep.camp.calculator.domain.model.Operand
import edu.nextstep.camp.calculator.domain.model.Operator
import edu.nextstep.camp.calculator.domain.model.ExpressionToken
import edu.nextstep.camp.calculator.domain.model.NegativeExpressionToken
import edu.nextstep.camp.calculator.domain.model.OtherExpressionToken
import org.jetbrains.annotations.TestOnly

class ExpressionTokenProcessor {
    private val expressionTokenList = mutableListOf<ExpressionToken>()

    fun processUserInputAction(expressionToken: ExpressionToken) : String {
        return when (expressionToken) {
            is OtherExpressionToken -> processOtherInput(expressionToken)
            is Operator -> processOperatorInput(expressionToken)
            is Operand -> processNumberInput(expressionToken)
            else -> throw IllegalArgumentException("Unknown Input Type")
        }
    }

    private fun processNumberInput(input: Operand) : String {
        return expressionTokenList.run {
            add(input)
            toExpression()
        }
    }

    private fun processOperatorInput(input: Operator) : String {
        return expressionTokenList.run {
            lastOrNull().also { lastToken ->
                when {
                    lastToken is Operand -> add(input)
                    input == Operator.SUBTRACTION && (lastToken is Operator || lastToken == null) -> add(NegativeExpressionToken())
                    input != Operator.SUBTRACTION && lastToken is Operator -> this[lastIndex] = input
                }
            }
            toExpression()
        }
    }

    private fun processOtherInput(input: OtherExpressionToken) : String {
        return when (input) {
            OtherExpressionToken.DEL -> expressionTokenList.run {
                removeLastOrNull()
                toExpression()
            }
            OtherExpressionToken.EQUALS -> evaluate()
            else -> throw IllegalArgumentException("Unknown Input")
        }
    }

    private fun evaluate(): String {
        val parsedStr = expressionTokenList.toExpression()
        if (!RegexUtils.checkExpressionIsValid(parsedStr)) {
            throw ExpressionNotCompleteException()
        }
        val result = Calculator.evaluate(parsedStr)
        expressionTokenList.clear()
        result.toString().forEach {
            ExpressionToken.getFromValue(it.toString()).let { token ->
                expressionTokenList.add(if (token == Operator.SUBTRACTION) NegativeExpressionToken() else token)
            }
        }

        return expressionTokenList.toExpression()
    }
    
    private fun List<ExpressionToken>.toExpression() : String {
        return joinToString(separator = "") {
            if (it is Operator) {
                " ${it.value} "
            } else {
                it.value.toString()
            }
        }
    }

    @TestOnly
    fun setCurrentDisplayedText(displayedText: String) : String{
        expressionTokenList.clear()
        val operands = RegexUtils.getOperandsList(displayedText)
        val operators = RegexUtils.getOperatorsList(displayedText)
        operands.forEachIndexed { index, operand ->
            operand.toString().forEach {
                expressionTokenList.add(ExpressionToken.getFromValue(it.toString()))
            }
            operators.getOrNull(index)?.let {
                expressionTokenList.add(ExpressionToken.getFromValue(it))
            }
        }
        return expressionTokenList.toExpression()
    }
}
