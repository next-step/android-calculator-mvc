package camp.nextstep.camp.calculator.domain

import camp.nextstep.camp.calculator.domain.Calculator.Operators.*


object Calculator {

    fun evaluate(input: String, delimiter: String): Int {
        requiredInput(input)

        val inputList: List<String> = input.split(delimiter)

        var result = inputList[0].toInt()

        for (index in 1 until inputList.size step 2) {
            result = calculate(inputList[index], result, inputList[index + 1].toInt())
        }

        return result
    }

    fun requiredInput(input: String?) {
        //입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
        if (input.isNullOrBlank()) throw IllegalArgumentException()
    }

    private fun calculate(operator: String, operandFirst: Int, operandSecond: Int): Int {
        return when (operator) {
            Plus.operator -> plus(operandFirst, operandSecond)
            Minus.operator -> minus(operandFirst, operandSecond)
            Multiply.operator -> multiply(operandFirst, operandSecond)
            Divide.operator -> divide(operandFirst, operandSecond)
            else -> throw IllegalArgumentException() //사칙연산 기호가 아닌 경우 IllegalArgumentException throw
        }
    }

    private fun plus(operandFirst: Int, operandSecond: Int) =
        operandFirst + operandSecond

    private fun minus(operandFirst: Int, operandSecond: Int) =
        operandFirst - operandSecond

    private fun multiply(operandFirst: Int, operandSecond: Int) =
        operandFirst * operandSecond

    private fun divide(operandFirst: Int, operandSecond: Int) =
        operandFirst / operandSecond

    enum class Operators(val operator: String) {
        Plus("+"),
        Minus("-"),
        Multiply("*"),
        Divide("/")
    }
}