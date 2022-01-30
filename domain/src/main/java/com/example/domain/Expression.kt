package com.example.domain

data class Expression(
    val value: String
) {

    operator fun plus(operator: String): Expression {
        if (Operand.check(operator)) {
            return empty()
        }
        return copy(value = "$value$operator")
    }

    operator fun plus(operand: Operand): Expression {
        if (value.isEmpty()) {
            return this
        }
        return copy(value = "$value${operand.operand}")
    }

    fun deleteLast(): Expression {
        if (value.isEmpty()) {
            return empty()
        }
        return copy(value = value.dropLast(1))
    }

    @Throws(IllegalArgumentException::class)
    fun express(calculator: Calculator): Expression {
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