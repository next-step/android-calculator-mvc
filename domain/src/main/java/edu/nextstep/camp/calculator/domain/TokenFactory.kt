package edu.nextstep.camp.calculator.domain

internal class TokenFactory {
    companion object {
        operator fun invoke(value: String): Token = value.toIntOrNull()?.let {
            Operand(it)
        } ?: run {
            Operator.get(value)
        }
    }
}
