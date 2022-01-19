package net.woogear.domain

enum class OperationType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    companion object {
        fun getOperationType(text: String): OperationType {
            return when (text) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                else -> DIVIDE
            }
        }

        fun isOperationType(text: String): Boolean {
            return text == "+" || text == "-" || text == "*" || text == "/"
        }
    }

    fun operate(newNumber: Int, oldNumber: Int): Int {
        return when (this) {
            PLUS -> oldNumber + newNumber
            MINUS -> oldNumber - newNumber
            MULTIPLY -> oldNumber * newNumber
            else -> oldNumber / newNumber
        }
    }
}