package edu.nextstep.camp.calculator.domain.raw

enum class RawSign(override val char: Char) : RawExpression {
    PLUS('+'),
    MINUS('-'),
    TIMES('*'),
    DIVISION('/'),
}
