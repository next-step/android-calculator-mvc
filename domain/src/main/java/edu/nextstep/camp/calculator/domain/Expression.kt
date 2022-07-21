package edu.nextstep.camp.calculator.domain

data class Expression(
    private val inputCalculatorContents: MutableList<String> = mutableListOf(),
    private val validator: Validator = Validator()
) {

    val values: String get() = inputCalculatorContents.joinToString("")

    fun addInputString(inputString: String) {
        if (validator.isOperator(inputString)) {
            isRepeatOperator(inputString)
            return
        }

        if (validator.isNumeric(inputString)) {
            inputCalculatorContents.add(inputString)
            return
        }

        throw IllegalArgumentException("잘못된 값이 전달 되었습니다.")
    }

    private fun isRepeatOperator(inputString: String) {
        if (inputCalculatorContents.isEmpty()) {
            return
        }

        val compareContent = inputCalculatorContents.last().trim()

        if (compareContent == inputString) {
            return
        }

        if (compareContent != inputString && validator.isOperator(compareContent)) {
            inputCalculatorContents[inputCalculatorContents.size - 1] = " $inputString "
            return
        }

        inputCalculatorContents.add(" $inputString ")
    }

    fun dropLast() {
        if (inputCalculatorContents.isNotEmpty()) {
            inputCalculatorContents.removeLast()
            return
        }

        throw IllegalArgumentException("마지막 값이 존재하지 않습니다.")
    }

    fun isLastValueOperatorCheck(): Boolean {
        val lastValue = inputCalculatorContents.last().trim()
        return validator.isOperator(lastValue)
    }

    fun complete(calculateString: String): String {
        inputCalculatorContents.clear()
        inputCalculatorContents.add(calculateString)
        return inputCalculatorContents.first()
    }

}