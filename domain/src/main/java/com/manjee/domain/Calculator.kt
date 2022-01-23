package com.manjee.domain

class Calculator {
    fun calculate(input: String?): Int {
        var currentValue = 0
        var formulaType = Operator.PLUS

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("입력 값은 null 이거나 비어있을 수 없습니다")
        } else if (!input.last().isDigit()) {
            throw IllegalArgumentException("완전하지 않은 수식입니다")
        }

        input.split(" ").forEach {
            when {
                Operator.isOperatorType(it) -> formulaType = Operator.getOperatorType(it)
                it.toIntOrNull() != null -> currentValue =
                    formulaType.calculate(currentValue, it.toInt())
            }
        }

        return currentValue
    }
}