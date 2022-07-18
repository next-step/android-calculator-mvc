package edu.nextstep.camp.calculator.domain.model

import edu.nextstep.camp.calculator.domain.RegexUtils


interface ExpressionToken {
    val value : Any?

    companion object {
        fun getFromValue(value: String) : ExpressionToken {
            val enumExpression = OtherExpressionToken.values().find {
                it.value == value
            } ?: Operator.values().find {
                it.value == value
            }
            return when {
                enumExpression != null -> enumExpression
                RegexUtils.checkExpressionIsOneDigitNumber(value) -> Operand(Integer.parseInt(value))
                else -> Operand(Integer.parseInt(value))
            }
        }
    }
}

enum class OtherExpressionToken(override val value: String?) : ExpressionToken {
    DEL("del"),
    EQUALS("="),
    UNKNOWN(null);
}

data class NegativeExpressionToken(override val value: String = "-") : ExpressionToken
