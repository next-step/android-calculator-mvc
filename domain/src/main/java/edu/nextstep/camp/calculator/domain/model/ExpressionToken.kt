package edu.nextstep.camp.calculator.domain.model

import edu.nextstep.camp.calculator.domain.RegexUtils


interface ExpressionToken {
    val value : Any?

    companion object {
        fun getFromValue(value: String) : ExpressionToken =
            getFromNonBlankValue(value.filterNot { it.isWhitespace() })

        private fun getFromNonBlankValue(value: String) : ExpressionToken {
            val enumExpression = OtherExpressionToken.find(value) ?: Operator.find(value)
            return when {
                enumExpression != null -> enumExpression
                RegexUtils.checkExpressionIsOneDigitNumber(value) -> Operand(Integer.parseInt(value))
                else -> OtherExpressionToken.UNKNOWN
            }
        }
    }
}

enum class OtherExpressionToken(override val value: String?) : ExpressionToken {
    DEL("del"),
    EQUALS("="),
    UNKNOWN(null);

    companion object {
        fun find(value: String) : OtherExpressionToken? = values().find { it.value == value }
    }
}

object NegativeExpressionToken : ExpressionToken {
    override val value: String = "-"
}
