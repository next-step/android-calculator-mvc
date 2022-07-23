package edu.nextstep.camp.calculator.domain

data class Expression(
    private val inputCalculatorContents: List<String> = emptyList(),
    private val validator: Validator = Validator()
) {

    operator fun plus(inputString: String): Expression {
        if (validator.isOperator(inputString.trim())) {
            return lastIndexValidateExpression(inputString.trim())
        }

        if (validator.isNumeric(inputString)) return Expression(inputCalculatorContents + inputString)

        throw IllegalArgumentException("잘못된 값이 전달 되었습니다. 입력 값 : $inputString")
    }

    private fun lastIndexValidateExpression(inputString: String): Expression {
        val lastValue = inputCalculatorContents.lastOrNull()
        return when {
            lastValue == null -> this
            validator.isOperator(lastValue.trim()) -> Expression(inputCalculatorContents.dropLast(1) + " $inputString ")
            validator.isNumeric(lastValue.trim()) -> Expression(inputCalculatorContents + " $inputString ")
            else -> throw IllegalArgumentException("마지막 값 검증을 실패했습니다. 입력값 : $inputString 마지막값 : $lastValue")
        }
    }

    fun dropLast(): Expression {
        if (inputCalculatorContents.isNotEmpty()) {
            return Expression(inputCalculatorContents.dropLast(1))
        }

        return this
    }

    fun isLastValueOperatorCheck(): Boolean {
        val lastValue = inputCalculatorContents.last().trim()
        return validator.isOperator(lastValue)
    }

    override fun toString(): String {
        return inputCalculatorContents.joinToString("")
    }

}