package net.woogear.domain

enum class OperationType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    companion object {
        fun getOperationType(text: String): OperationType {
            return when (text) {
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> PLUS
            }
        }
    }

    fun isPlus(): Boolean {
        return this == PLUS
    }

    fun isMinus(): Boolean {
        return this == MINUS
    }

    fun isMultiply(): Boolean {
        return this == MULTIPLY
    }

    fun isDivide(): Boolean {
        return this == DIVIDE
    }
}