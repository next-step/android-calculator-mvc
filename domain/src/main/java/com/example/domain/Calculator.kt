package com.example.domain

class Calculator {

    private var opertaion: Operation? = null
    private var result = 0f

    fun evaluate(inputs: String): Float {
        initValue()
        inputs.forEachIndexed { index, _value ->
            val value = _value.toString()
            val type = index % 2
            when (type) {
                EVEN_IS_NUMBER -> {
                    calculateNumber(value)
                }
                ODD_IS_OPERATION -> {
                    setOperator(value)
                }
                else -> {
                    throw IllegalArgumentException()
                }
            }
        }

        return result
    }

    private fun initValue() {
        opertaion = null
        result = 0f
    }

    private fun setOperator(value: String) {
        if (Operation.check(value).not()) {
            throw IllegalArgumentException()
        }
        opertaion = Operation.get(value)
    }

    private fun calculateNumber(value: String) {
        val number = value.toFloatOrNull() ?: throw IllegalArgumentException()

        if (opertaion == null) {
            result = number
            return
        }

        result = Operation.calculate(result, opertaion!!, number)
    }

    companion object {

        private const val EVEN_IS_NUMBER = 0

        private const val ODD_IS_OPERATION = 1
    }
}

