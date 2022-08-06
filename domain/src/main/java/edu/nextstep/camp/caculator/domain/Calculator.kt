package edu.nextstep.camp.caculator.domain

class Calculator {

    fun calculate(expression: Expression): Int {
        return operate(expression.toExpressionData())
    }

    private fun operate(expressionData: ExpressionData): Int = when(expressionData) {
        is ExpressionData.Essence -> expressionData.essence
        is ExpressionData.Sum -> operate(expressionData.expression1) + operate(expressionData.expression2)
        is ExpressionData.Subtract -> operate(expressionData.expression1) - operate(expressionData.expression2)
        is ExpressionData.Divide -> operate(expressionData.expression1) / operate(expressionData.expression2)
        is ExpressionData.Multiply -> operate(expressionData.expression1) * operate(expressionData.expression2)
        else -> 0
    }
}