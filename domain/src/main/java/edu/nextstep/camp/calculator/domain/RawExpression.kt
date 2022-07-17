package edu.nextstep.camp.calculator.domain

sealed interface RawExpression {

    class Builder {

        private var expression = ""

        fun enterNumber(number: Number): Builder {
            expression += number.char
            return this
        }

        fun build(): String {
            return expression
        }

        fun enterSign(sign: Sign): Builder {
            expression += " ${sign.char}"
            return this
        }
    }

    enum class Number(val char: Char) : RawExpression {
        ZERO('0'),
        ONE('1'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
    }

    enum class Sign(val char: Char) : RawExpression {
        PLUS('+'),
        MINUS('-'),
        TIMES('*'),
        DIVISION('/'),
    }
}
