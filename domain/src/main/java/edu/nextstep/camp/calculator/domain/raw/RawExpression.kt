package edu.nextstep.camp.calculator.domain.raw

sealed interface RawExpression {

    val char: Char

    class Builder {

        private var rawList = listOf<RawExpression>()

        fun enterNumber(number: RawNumber): Builder {
            rawList = rawList + number
            return this
        }

        fun enterSign(sign: RawSign): Builder {
            when {
                rawList.isEmpty() -> {}
                rawList.lastOrNull() is RawSign -> {
                    rawList = rawList.dropLast(1) + sign
                }
                else -> {
                    rawList = rawList + sign
                }
            }

            return this
        }

        fun build(): String {
            return rawList.foldIndexed("") { i, acc, exp ->
                acc + when {
                    acc.isEmpty() -> exp.char
                    rawList[i - 1] is RawNumber && exp is RawNumber -> exp.char
                    else -> " ${exp.char}"
                }
            }
        }

        fun remove(): Builder {
            rawList = rawList.dropLast(1)
            return this
        }
    }
}
