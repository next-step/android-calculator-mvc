package com.example.domain

class Calculator {

    companion object {

        private const val NUMBER = 0

        private const val OPERATION = 1
    }

    fun evaluate(inputs: String): Float {
        var opertaion: Operation? = null
        var result = 0f

        inputs.forEachIndexed { index, _value ->
            val value = _value.toString()
            val type = index % 2

            if (type == NUMBER) {
                val number = value.toFloatOrNull() ?: throw IllegalArgumentException()

                if (opertaion != null) {
                    result = Operation.calculator(result, opertaion!!, number)
                    opertaion = null
                } else {
                    result = number
                }
            } else if (type == OPERATION) {
                if (Operation.check(value).not()) {
                    throw IllegalArgumentException()
                }

                opertaion = Operation.get(value)
            } else {
                throw IllegalArgumentException()
            }
        }

        return result
    }
}

