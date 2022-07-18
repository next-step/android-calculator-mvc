package edu.nextstep.camp.calculator.domain.model

import edu.nextstep.camp.calculator.domain.RegexUtils


interface UserInputAction {
    val value : Any?

    companion object {
        fun getFromValue(value: String) : UserInputAction {
            return when (value) {
                Operator.SUBTRACTION.value -> Operator.SUBTRACTION
                Operator.ADDITION.value -> Operator.ADDITION
                Operator.MULTIPLICATION.value -> Operator.MULTIPLICATION
                Operator.DIVISION.value -> Operator.DIVISION
                OtherInputAction.DEL.value -> OtherInputAction.DEL
                OtherInputAction.EQUALS.value -> OtherInputAction.EQUALS
                else -> {
                    // UserInputAction은 숫자 하나씩만 처리하기위해 1자리수 숫자만 허용한다
                    if (RegexUtils.checkExpressionIsOneDigitNumber(value)) Operand(Integer.parseInt(value))
                    else OtherInputAction.UNKNOWN
                }
            }
        }
    }
}

enum class OtherInputAction(override val value: String?) : UserInputAction {
    DEL("del"),
    EQUALS("="),
    UNKNOWN(null);
}
