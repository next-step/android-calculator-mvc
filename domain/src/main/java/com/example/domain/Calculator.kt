package com.example.domain

class Calculator {
    private var value = 0
    private var operation: Operation =Operation.PLUS
    private var number: Int = 0

    fun evaluate(inputText: String?): Int {

        divideTextType(inputText)

        return value
    }

    private fun divideTextType(inputText:String?){
        if (inputText.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자 입니다.")
        }
        val splitTexts: List<String> = inputText.split(" ")

        for (text in splitTexts) {
            when {
                operation.checkOperationType(text) -> {
                    operation = operation.changeTextToOperation(text)
                }
                text.checkIntType() -> {
                    number = text.toInt()
                    operationType()

                }
                else -> {
                    throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
                }
            }


        }
    }

    private fun operationType() { //사칙 연산 수행
        when (operation) {
            Operation.PLUS -> {
                value += number
                return
            }
            Operation.MINUS -> {
                value -= number
                return
            }
            Operation.MULTIPLY -> {
                value *= number
                return
            }
            Operation.DIVIDE -> {
                value /= number
                return
            }
        }

    }

    private fun String.checkIntType(): Boolean { //입력된 문자가 숫자인지 체크
        return when (toIntOrNull()) {
            null -> false
            else -> true
        }
    }

}