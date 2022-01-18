package net.woogear.domain

class Calculator {
    private var answer = 0
    private var operationType: OperationType = OperationType.PLUS

    fun evaluate(s: String?): Int {
        if (s.isNullOrEmpty()) {
            throw IllegalArgumentException("Input Text Can't Be a Null or Empty")
        }

        splitAndCheck(s)
        return answer
    }

    private fun splitAndCheck(input: String) {
        val splitTexts: List<String> = input.split(" ")

        for (text in splitTexts) {
            if (isOperationType(text)) {
                operationType = OperationType.getOperationType(text)
                continue
            }

            if (text.isInt()) {
                operateByType(text.toInt(), operationType)
                continue
            }

            throw IllegalArgumentException("$text is not supported type for input text")
        }
    }

    private fun isOperationType(text: String): Boolean {
        return text == "+" || text == "-" || text == "*" || text == "/"
    }

    private fun operateByType(number: Int, operationType: OperationType) {
        if (operationType.isPlus()) {
            answer += number
            return
        }
        
        if (operationType.isMinus()) {
            answer -= number
            return
        }

        if (operationType.isMultiply()) {
            answer *= number
            return
        }

        if (operationType.isDivide()) {
            answer /= number
            return
        }
    }

    private fun String.isInt(): Boolean {
        return when(toIntOrNull()) {
            null -> false
            else -> true
        }
    }
}