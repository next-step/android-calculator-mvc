package net.woogear.domain

enum class OperationType {
    PLUS {
        override fun calculate(newNumber: Int, oldNumber: Int): Int {
            return oldNumber + newNumber
        }
    },
    MINUS {
        override fun calculate(newNumber: Int, oldNumber: Int): Int {
            return oldNumber - newNumber
        }

    },
    MULTIPLY {
        override fun calculate(newNumber: Int, oldNumber: Int): Int {
            return oldNumber * newNumber
        }
    },
    DIVIDE {
        override fun calculate(newNumber: Int, oldNumber: Int): Int {
            return oldNumber / newNumber
        }
    };

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

    abstract fun calculate(newNumber: Int, oldNumber: Int): Int
}