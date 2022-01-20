package edu.nextstep.camp.calculator.domain

class Calculator {

    fun evaluate(data: String): Float {
        var result = 0f
        var operator = "none"

        if (data.isEmpty()) {
            throw IllegalArgumentException("exception data")
        } else {
            data.forEach {
                if (it.isDigit()) { // 숫자
                    when (operator) {
                        "+" -> result = plus(result, Character.getNumericValue(it).toFloat())
                        "-" -> result = minus(result, Character.getNumericValue(it).toFloat())
                        "*" -> result = multipliedBy(result, Character.getNumericValue(it).toFloat())
                        "/" -> result = dividedBy(result, Character.getNumericValue(it).toFloat())
                        "none" -> result = Character.getNumericValue(it).toFloat()
                    }
                } else { // 연산
                    when (it.toString()) {
                        "+" -> operator = "+"
                        "-" -> operator = "-"
                        "×" -> operator = "*"
                        "÷" -> operator = "/"
                        else -> throw IllegalArgumentException("exception operator")
                    }
                }
            }
        }
        return result
    }

    fun plus(first: Float, second: Float): Float {
        return first + second
    }

    fun minus(first: Float, second: Float): Float {
        return first - second
    }

    fun multipliedBy(first: Float, second: Float): Float {
        return first * second
    }

    fun dividedBy(first: Float, second: Float): Float {
        return first / second
    }
}