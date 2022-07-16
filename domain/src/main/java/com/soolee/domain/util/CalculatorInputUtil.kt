package com.soolee.domain.util

class CalculatorInputUtil {
    fun checkIsNumberTypeString(text: String): Boolean {
        var regex = Regex("[0-9]")
        return (text.matches(regex))
    }
}