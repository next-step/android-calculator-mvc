package edu.nextstep.camp.calculator.domain.operand

data class NumberOperand(
    private var number: Double
) : Operand {
    override fun toString(): String {
        return number.toInt().toString()
    }

    fun deleteLast(): NumberOperand? {
        val number = toString()
        return if (number.length > 1) {
            NumberOperand(number.dropLast(1).toDouble())
        } else {
            null
        }
    }

    fun addNumberOperand(inputNumberOperand: NumberOperand): NumberOperand {
        val number = addString(inputNumberOperand)
        return NumberOperand(number.toDouble())
    }

    private fun addString(operand: NumberOperand): String {
        return "${number.toInt()}${operand.number.toInt()}"
    }
}
