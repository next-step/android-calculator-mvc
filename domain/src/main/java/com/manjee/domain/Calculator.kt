package com.manjee.domain

class Calculator {
    fun calculate(input: String?): Int {
        var currentValue = 0

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("입력 값은 null 이거나 비어있을 수 없습니다 (현재 입력값: $input)")
        } else if (!input.last().isDigit()) {
            throw IllegalArgumentException("완전하지 않은 수식입니다 (현재 수식: $input)")
        }

        val inputResult = input.split(" ")
        currentValue = inputResult.first().toInt()

        inputResult.drop(1).chunked(2) {
            currentValue =
                Operator.isOperatorType(it.first()).calculate(currentValue, it.last().toInt())
        }

        return currentValue
    }
}