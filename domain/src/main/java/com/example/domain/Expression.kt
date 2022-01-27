package com.example.domain

data class Expression(
    val value: String
) {

    private val calculator = Calculator()

    fun addText(input: String): Expression {
        if (Operand.check(input)) {
            return empty()
        }
        return copy(value = "$value$input")
    }

    fun delete(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = value.dropLast(1))
    }

    fun divide(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = "$value${Operand.DIVISION.operand}")
    }

    fun multiply(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = "$value${Operand.MULTIPLICATION.operand}")
    }

    fun minus(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = "$value${Operand.SUBTRACTION.operand}")
    }

    fun plus(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = "$value${Operand.PLUS.operand}")
    }

    @Throws(IllegalArgumentException::class)
    fun equals(): Expression {
        val equalsBuilder = StringBuilder()

        value.forEach { input ->
            val inputForCalculate = getInputForCalculate(input)
            equalsBuilder.append(inputForCalculate)
        }

        val result = calculator.evaluate(equalsBuilder.toString()).toInt()
        return copy(value = result.toString())
    }

    private fun getInputForCalculate(input: Char) = if (Operand.check(input.toString())) {
        "$SEPARATOR$input$SEPARATOR"
    } else {
        input.toString()
    }

    companion object {

        private const val SEPARATOR = " "

        fun empty() = Expression("")
    }
}