package edu.nextstep.calculator.domain

enum class Operation(value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),

    UNDEFINED("UNDEFINED");

    companion object {
        fun toOperation(operationValue: String): Operation {
            return when (operationValue) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> UNDEFINED
            }
        }
    }
}
