package com.example.calculator

class Calculator {
    private val regex = "[0-9]".toRegex()

    fun getNumber(inputNumber: CharSequence): String {
        return if (regex.matches(inputNumber))
            inputNumber.toString() else ""
    }

}