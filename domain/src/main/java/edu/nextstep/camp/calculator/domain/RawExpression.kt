package edu.nextstep.camp.calculator.domain

sealed interface RawExpression {

    class Builder {

        private var rawList = listOf<RawExpression>()

        fun enterNumber(number: Number): Builder {
            rawList = rawList + number
            return this
        }

        fun enterSign(sign: Sign): Builder {
            when {
                rawList.isEmpty() -> {}
                rawList.lastOrNull() is Sign -> {
                    rawList = rawList.dropLast(1) + sign
                }
                else -> {
                    rawList = rawList + sign
                }
            }

            return this
        }

        fun build(): String {
            return rawList.fold("") { acc, exp ->
                acc + when (exp) {
                    is Number -> exp.char
                    is Sign -> " ${exp.char}"
                }
            }
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
