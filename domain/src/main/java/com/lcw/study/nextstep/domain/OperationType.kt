package com.lcw.study.nextstep.domain

enum class OperationType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    NOT_OPERATION_TYPE;

    fun checkTextIsOperationType(text: String): Boolean {
        return text == "+" || text == "-" || text == "*" || text == "/"
    }

    fun changeTextToOperation(text: String): OperationType {
        when (text) {
            "+" -> return PLUS
            "-" -> return MINUS
            "*" -> return MULTIPLY
            "/" -> return DIVIDE
        }
        return NOT_OPERATION_TYPE
    }

    fun calculateOperation(operation: OperationType, totalValue: Int, inputValue: Int): Int {
        return when (operation) {
            PLUS -> {
                totalValue + inputValue
            }
            MINUS -> {
                totalValue - inputValue
            }
            MULTIPLY -> {
                totalValue * inputValue
            }
            DIVIDE -> {
                totalValue / inputValue
            }
            else -> totalValue
        }

    }
}