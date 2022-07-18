package edu.nextstep.camp.calculator.domain.model

import edu.nextstep.camp.calculator.domain.RegexUtils


interface ExpressionToken {
    val value : Any?

    companion object {
        fun getFromValue(value: String) : ExpressionToken {
            return when (value) {
                Operator.SUBTRACTION.value -> Operator.SUBTRACTION
                Operator.ADDITION.value -> Operator.ADDITION
                Operator.MULTIPLICATION.value -> Operator.MULTIPLICATION
                Operator.DIVISION.value -> Operator.DIVISION
                OtherExpressionToken.DEL.value -> OtherExpressionToken.DEL
                OtherExpressionToken.EQUALS.value -> OtherExpressionToken.EQUALS
                else -> {
                    // ExpressionToken은 숫자 하나씩만 처리하기위해 1자리수 숫자만 허용한다
                    if (RegexUtils.checkExpressionIsOneDigitNumber(value)) Operand(Integer.parseInt(value))
                    else OtherExpressionToken.UNKNOWN
                }
            }
        }
    }
}

enum class OtherExpressionToken(override val value: String?) : ExpressionToken {
    DEL("del"),
    EQUALS("="),
    UNKNOWN(null);
}
