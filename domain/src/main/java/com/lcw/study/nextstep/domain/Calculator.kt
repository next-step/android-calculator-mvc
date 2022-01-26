package com.lcw.study.nextstep.domain

class Calculator {
    private var value = 0
    private var operation: OperationType = OperationType.PLUS
    private var number: Int = 0

    fun evaluate(inputText: String?): Int {

        if (inputText.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자 입니다.")
        }
        val splitTexts: List<String> = inputText.split(" ")

        for (text in splitTexts) {
            when {
                operation.checkTextIsOperationType(text) -> {
                    operation = operation.changeTextToOperation(text)
                }
                text.toIntOrNull() != null -> {
                    number = text.toInt()
                    value = operation.calculateOperation(operation, value, number)

                }
                else -> {
                    throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
                }
            }


        }

        return value
    }


}