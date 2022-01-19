package com.lcw.study.nextstep.domain

class Calculator {
    private var value = 0
    private var operation: String = "+"
    private var number: Int = 0

    fun evaluate(inputText: String?): Int {
        if (inputText.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자 입니다.")
        }
        val splitTexts: List<String> = (inputText.split(" "))

        for (text in splitTexts) {
            when {
                isOperationType(text) -> {
                    operation = text

                }
                text.isInt() -> {
                    number = text.toInt()
                    operationType()

                }
                else -> {
                    throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
                }
            }


        }

        return value
    }


    private fun isOperationType(text: String): Boolean { //입력된 문자가 사칙 연산 기호인지 체크
        return text == "+" || text == "-" || text == "*" || text == "/"
    }

    private fun operationType() { //사칙 연산 수행
        when (operation) {
            "+" -> {
                value += number
                return
            }
            "-" -> {
                value -= number
                return
            }
            "*" -> {
                value *= number
                return
            }
            "/" -> {
                value /= number
                return
            }
        }

    }

    private fun String.isInt(): Boolean { //입력된 문자가 숫자인지 체크
        return when (toIntOrNull()) {
            null -> false
            else -> true
        }
    }

}