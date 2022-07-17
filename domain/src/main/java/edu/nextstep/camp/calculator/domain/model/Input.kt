package edu.nextstep.camp.calculator.domain.model

interface Input {
    val value : String

    companion object {
        fun getFromValue(value: String) : Input {
            return when(value) {
                "0" -> NumberInput.ZERO
                "1" -> NumberInput.ONE
                "2" -> NumberInput.TWO
                "3" -> NumberInput.THREE
                "4" -> NumberInput.FOUR
                "5" -> NumberInput.FIVE
                "6" -> NumberInput.SIX
                "7" -> NumberInput.SEVEN
                "8" -> NumberInput.EIGHT
                "9" -> NumberInput.NINE
                "-" -> OperatorInput.MINUS
                "+" -> OperatorInput.PLUS
                "×" -> OperatorInput.MULTIPLY
                "÷" -> OperatorInput.DIV
                "del" -> OtherInput.DEL
                "=" -> OtherInput.EQUALS
                else -> OtherInput.UNKNOWN
            }
        }
    }
}

enum class NumberInput(override val value: String) : Input{
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");
}

enum class OperatorInput(override val value: String) : Input {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIV("÷");
}

enum class OtherInput(override val value: String) : Input {
    DEL("del"),
    EQUALS("="),
    UNKNOWN("unknown");
}
