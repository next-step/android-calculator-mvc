package net.woogear.domain

class Calculator {

    fun evaluate(inputText: String?): Int {
        if (inputText.isNullOrEmpty()) {
            throw IllegalArgumentException("Input Text Can't Be a Null or Empty")
        }

        val delimiter = " "
        return calculate(inputText.split(delimiter))
    }

    private fun calculate(splitTexts: List<String>): Int {
        var answer = 0
        var operationType: OperationType = OperationType.PLUS

        for (text in splitTexts) {
            when {
                text.isOperator() -> operationType = OperationType.getOperationType(text)
                text.isInt() -> answer = operationType.calculate(text.toInt(), answer)
                else -> throw IllegalArgumentException("$text is not supported type for input text")
            }
        }

        return answer
    }

    private fun String.isOperator(): Boolean {
        return OperationType.isOperator(this)
    }

    private fun String.isInt(): Boolean {
        return toIntOrNull() != null
    }
}